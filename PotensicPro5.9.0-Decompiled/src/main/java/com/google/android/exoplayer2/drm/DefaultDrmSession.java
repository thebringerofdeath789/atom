package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
class DefaultDrmSession implements DrmSession {
    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    final MediaDrmCallback callback;
    private ExoMediaDrm.KeyRequest currentKeyRequest;
    private ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> eventDispatchers;
    private final boolean isPlaceholderSession;
    private final HashMap<String, String> keyRequestParameters;
    private DrmSession.DrmSessionException lastException;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private ExoMediaCrypto mediaCrypto;
    private final ExoMediaDrm mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final ProvisioningManager provisioningManager;
    private int referenceCount;
    private final ReferenceCountListener referenceCountListener;
    private RequestHandler requestHandler;
    private HandlerThread requestHandlerThread;
    final ResponseHandler responseHandler;
    public final List<DrmInitData.SchemeData> schemeDatas;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(Exception exc);

        void provisionRequired(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int i);

        void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int i);
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable th) {
            super(th);
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, List<DrmInitData.SchemeData> list, int i, boolean z, boolean z2, byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.uuid = uuid;
        this.provisioningManager = provisioningManager;
        this.referenceCountListener = referenceCountListener;
        this.mediaDrm = exoMediaDrm;
        this.mode = i;
        this.playClearSamplesWithoutKeys = z;
        this.isPlaceholderSession = z2;
        if (bArr != null) {
            this.offlineLicenseKeySetId = bArr;
            this.schemeDatas = null;
        } else {
            this.schemeDatas = Collections.unmodifiableList((List) Assertions.checkNotNull(list));
        }
        this.keyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.eventDispatchers = new CopyOnWriteMultiset<>();
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.state = 2;
        this.responseHandler = new ResponseHandler(looper);
    }

    public boolean hasSessionId(byte[] bArr) {
        return Arrays.equals(this.sessionId, bArr);
    }

    public void onMediaDrmEvent(int i) {
        if (i != 2) {
            return;
        }
        onKeysRequired();
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        ((RequestHandler) Util.castNonNull(this.requestHandler)).post(0, Assertions.checkNotNull(this.currentProvisionRequest), true);
    }

    public void onProvisionCompleted() {
        if (openInternal()) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception exc) {
        onError(exc);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.playClearSamplesWithoutKeys;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID getSchemeUuid() {
        return this.uuid;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final ExoMediaCrypto getMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkState(this.referenceCount >= 0);
        if (eventDispatcher != null) {
            this.eventDispatchers.add(eventDispatcher);
        }
        int i = this.referenceCount + 1;
        this.referenceCount = i;
        if (i == 1) {
            Assertions.checkState(this.state == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.requestHandlerThread = handlerThread;
            handlerThread.start();
            this.requestHandler = new RequestHandler(this.requestHandlerThread.getLooper());
            if (openInternal()) {
                doLicense(true);
            }
        } else if (eventDispatcher != null && isOpen() && this.eventDispatchers.count(eventDispatcher) == 1) {
            eventDispatcher.drmSessionAcquired(this.state);
        }
        this.referenceCountListener.onReferenceCountIncremented(this, this.referenceCount);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkState(this.referenceCount > 0);
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            this.state = 0;
            ((ResponseHandler) Util.castNonNull(this.responseHandler)).removeCallbacksAndMessages(null);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).release();
            this.requestHandler = null;
            ((HandlerThread) Util.castNonNull(this.requestHandlerThread)).quit();
            this.requestHandlerThread = null;
            this.mediaCrypto = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            byte[] bArr = this.sessionId;
            if (bArr != null) {
                this.mediaDrm.closeSession(bArr);
                this.sessionId = null;
            }
        }
        if (eventDispatcher != null) {
            this.eventDispatchers.remove(eventDispatcher);
            if (this.eventDispatchers.count(eventDispatcher) == 0) {
                eventDispatcher.drmSessionReleased();
            }
        }
        this.referenceCountListener.onReferenceCountDecremented(this, this.referenceCount);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean openInternal() {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] openSession = this.mediaDrm.openSession();
            this.sessionId = openSession;
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(openSession);
            final int i = 3;
            this.state = 3;
            dispatchEvent(new Consumer() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$DxYpyadwFcAWqoX__uGLq-0ZR2E
                @Override // com.google.android.exoplayer2.util.Consumer
                public final void accept(Object obj) {
                    ((DrmSessionEventListener.EventDispatcher) obj).drmSessionAcquired(i);
                }
            });
            Assertions.checkNotNull(this.sessionId);
            return true;
        } catch (NotProvisionedException unused) {
            this.provisioningManager.provisionRequired(this);
            return false;
        } catch (Exception e) {
            onError(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(Object obj, Object obj2) {
        if (obj == this.currentProvisionRequest) {
            if (this.state == 2 || isOpen()) {
                this.currentProvisionRequest = null;
                if (obj2 instanceof Exception) {
                    this.provisioningManager.onProvisionError((Exception) obj2);
                    return;
                }
                try {
                    this.mediaDrm.provideProvisionResponse((byte[]) obj2);
                    this.provisioningManager.onProvisionCompleted();
                } catch (Exception e) {
                    this.provisioningManager.onProvisionError(e);
                }
            }
        }
    }

    @RequiresNonNull({"sessionId"})
    private void doLicense(boolean z) {
        if (this.isPlaceholderSession) {
            return;
        }
        byte[] bArr = (byte[]) Util.castNonNull(this.sessionId);
        int i = this.mode;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.offlineLicenseKeySetId == null || restoreKeys()) {
                    postKeyRequest(bArr, 2, z);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            Assertions.checkNotNull(this.offlineLicenseKeySetId);
            Assertions.checkNotNull(this.sessionId);
            postKeyRequest(this.offlineLicenseKeySetId, 3, z);
            return;
        }
        if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(bArr, 1, z);
            return;
        }
        if (this.state == 4 || restoreKeys()) {
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
            if (this.mode == 0 && licenseDurationRemainingSec <= 60) {
                Log.d(TAG, new StringBuilder(88).append("Offline license has expired or will expire soon. Remaining seconds: ").append(licenseDurationRemainingSec).toString());
                postKeyRequest(bArr, 2, z);
            } else if (licenseDurationRemainingSec <= 0) {
                onError(new KeysExpiredException());
            } else {
                this.state = 4;
                dispatchEvent(new Consumer() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$bKbtDH-u_QKCKrOHwO53RHdbHaY
                    @Override // com.google.android.exoplayer2.util.Consumer
                    public final void accept(Object obj) {
                        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysRestored();
                    }
                });
            }
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e) {
            onError(e);
            return false;
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void postKeyRequest(byte[] bArr, int i, boolean z) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(bArr, this.schemeDatas, i, this.keyRequestParameters);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).post(1, Assertions.checkNotNull(this.currentKeyRequest), z);
        } catch (Exception e) {
            onKeysError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(Object obj, Object obj2) {
        if (obj == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (obj2 instanceof Exception) {
                onKeysError((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse((byte[]) Util.castNonNull(this.offlineLicenseKeySetId), bArr);
                    dispatchEvent(new Consumer() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$BcEzLefIcAN2HB1XXErCxeZoNtI
                        @Override // com.google.android.exoplayer2.util.Consumer
                        public final void accept(Object obj3) {
                            ((DrmSessionEventListener.EventDispatcher) obj3).drmKeysRemoved();
                        }
                    });
                    return;
                }
                byte[] provideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                int i = this.mode;
                if ((i == 2 || (i == 0 && this.offlineLicenseKeySetId != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                    this.offlineLicenseKeySetId = provideKeyResponse;
                }
                this.state = 4;
                dispatchEvent(new Consumer() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$Xjvhz80h6FXicBD5mO_f_e7Cy8M
                    @Override // com.google.android.exoplayer2.util.Consumer
                    public final void accept(Object obj3) {
                        ((DrmSessionEventListener.EventDispatcher) obj3).drmKeysLoaded();
                    }
                });
            } catch (Exception e) {
                onKeysError(e);
            }
        }
    }

    private void onKeysRequired() {
        if (this.mode == 0 && this.state == 4) {
            Util.castNonNull(this.sessionId);
            doLicense(false);
        }
    }

    private void onKeysError(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(exc);
        }
    }

    private void onError(final Exception exc) {
        this.lastException = new DrmSession.DrmSessionException(exc);
        Log.e(TAG, "DRM session error", exc);
        dispatchEvent(new Consumer() { // from class: com.google.android.exoplayer2.drm.-$$Lambda$DefaultDrmSession$0hCnRa6YHjaCNNZgu2TzChKNNEQ
            @Override // com.google.android.exoplayer2.util.Consumer
            public final void accept(Object obj) {
                ((DrmSessionEventListener.EventDispatcher) obj).drmSessionManagerError(exc);
            }
        });
        if (this.state != 4) {
            this.state = 1;
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean isOpen() {
        int i = this.state;
        return i == 3 || i == 4;
    }

    private void dispatchEvent(Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        Iterator<DrmSessionEventListener.EventDispatcher> it = this.eventDispatchers.elementSet().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    private class RequestHandler extends Handler {
        private boolean isReleased;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        void post(int i, Object obj, boolean z) {
            obtainMessage(i, new RequestTask(LoadEventInfo.getNewId(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Throwable th;
            RequestTask requestTask = (RequestTask) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    th = DefaultDrmSession.this.callback.executeProvisionRequest(DefaultDrmSession.this.uuid, (ExoMediaDrm.ProvisionRequest) requestTask.request);
                } else if (i == 1) {
                    th = DefaultDrmSession.this.callback.executeKeyRequest(DefaultDrmSession.this.uuid, (ExoMediaDrm.KeyRequest) requestTask.request);
                } else {
                    throw new RuntimeException();
                }
            } catch (MediaDrmCallbackException e) {
                boolean maybeRetryRequest = maybeRetryRequest(message, e);
                th = e;
                if (maybeRetryRequest) {
                    return;
                }
            } catch (Exception e2) {
                Log.w(DefaultDrmSession.TAG, "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                th = e2;
            }
            DefaultDrmSession.this.loadErrorHandlingPolicy.onLoadTaskConcluded(requestTask.taskId);
            synchronized (this) {
                if (!this.isReleased) {
                    DefaultDrmSession.this.responseHandler.obtainMessage(message.what, Pair.create(requestTask.request, th)).sendToTarget();
                }
            }
        }

        private boolean maybeRetryRequest(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException unexpectedDrmSessionException;
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.allowRetry) {
                return false;
            }
            requestTask.errorCount++;
            if (requestTask.errorCount > DefaultDrmSession.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            LoadEventInfo loadEventInfo = new LoadEventInfo(requestTask.taskId, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.startTimeMs, mediaDrmCallbackException.bytesLoaded);
            MediaLoadData mediaLoadData = new MediaLoadData(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                unexpectedDrmSessionException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                unexpectedDrmSessionException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long retryDelayMsFor = DefaultDrmSession.this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, unexpectedDrmSessionException, requestTask.errorCount));
            if (retryDelayMsFor == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                if (this.isReleased) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), retryDelayMsFor);
                return true;
            }
        }

        public synchronized void release() {
            removeCallbacksAndMessages(null);
            this.isReleased = true;
        }
    }

    private static final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long startTimeMs;
        public final long taskId;

        public RequestTask(long j, boolean z, long j2, Object obj) {
            this.taskId = j;
            this.allowRetry = z;
            this.startTimeMs = j2;
            this.request = obj;
        }
    }
}
