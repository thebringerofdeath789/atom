package com.mapbox.android.telemetry;

import com.mapbox.android.telemetry.Event;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;

/* loaded from: classes3.dex */
public class VisionEventFactory {
    private static final String APPLICATION_CONTEXT_CANT_BE_NULL = "Create a MapboxTelemetry instance before calling this method.";
    private static final String NOT_A_VISION_EVENT_TYPE = "Type must be a vision event.";
    private final Map<Event.Type, VisionBuildEvent> BUILD_EVENT_VISION = new HashMap<Event.Type, VisionBuildEvent>() { // from class: com.mapbox.android.telemetry.VisionEventFactory.1
        {
            put(Event.Type.VIS_GENERAL, new VisionBuildEvent() { // from class: com.mapbox.android.telemetry.VisionEventFactory.1.1
                @Override // com.mapbox.android.telemetry.VisionBuildEvent
                public Event build() {
                    return VisionEventFactory.this.buildVisionEvent();
                }
            });
        }
    };

    public VisionEventFactory() {
        if (MapboxTelemetry.applicationContext == null) {
            throw new IllegalStateException(APPLICATION_CONTEXT_CANT_BE_NULL);
        }
    }

    public Event createVisionEvent(Event.Type type) {
        if (type == Event.Type.VIS_OBJ_DETECTION) {
            throw new UnsupportedOperationException("Unsupported event type: " + type.name());
        }
        checkVisionEvent(type);
        return this.BUILD_EVENT_VISION.get(type).build();
    }

    public FileAttachment createFileAttachment(String str, MediaType mediaType, AttachmentMetadata attachmentMetadata) {
        return new FileAttachment(attachmentMetadata, str, mediaType);
    }

    public Attachment createAttachment(Event.Type type) {
        checkVisionEvent(type);
        return buildAttachment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VisionEvent buildVisionEvent() {
        return new VisionEvent();
    }

    private Attachment buildAttachment() {
        return new Attachment();
    }

    private void checkVisionEvent(Event.Type type) {
        checkEventType(type);
    }

    private void checkEventType(Event.Type type) {
        if (!Event.visionEventTypes.contains(type)) {
            throw new IllegalArgumentException(NOT_A_VISION_EVENT_TYPE);
        }
    }
}