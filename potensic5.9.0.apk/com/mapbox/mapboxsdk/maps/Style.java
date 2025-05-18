package com.mapbox.mapboxsdk.maps;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Pair;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.TransitionOptions;
import com.mapbox.mapboxsdk.style.light.Light;
import com.mapbox.mapboxsdk.style.sources.Source;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Style {
    public static final String DARK = "mapbox://styles/mapbox/dark-v10";
    static final String EMPTY_JSON = "{\"version\": 8,\"sources\": {},\"layers\": []}";
    public static final String LIGHT = "mapbox://styles/mapbox/light-v10";
    public static final String MAPBOX_STREETS = "mapbox://styles/mapbox/streets-v11";
    public static final String OUTDOORS = "mapbox://styles/mapbox/outdoors-v11";
    public static final String SATELLITE = "mapbox://styles/mapbox/satellite-v9";
    public static final String SATELLITE_STREETS = "mapbox://styles/mapbox/satellite-streets-v11";
    public static final String TRAFFIC_DAY = "mapbox://styles/mapbox/traffic-day-v2";
    public static final String TRAFFIC_NIGHT = "mapbox://styles/mapbox/traffic-night-v2";
    private final Builder builder;
    private boolean fullyLoaded;
    private final HashMap<String, Bitmap> images;
    private final HashMap<String, Layer> layers;
    private final NativeMap nativeMap;
    private final HashMap<String, Source> sources;

    public interface OnStyleLoaded {
        void onStyleLoaded(Style style);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleUrl {
    }

    private Style(Builder builder, NativeMap nativeMap) {
        this.sources = new HashMap<>();
        this.layers = new HashMap<>();
        this.images = new HashMap<>();
        this.builder = builder;
        this.nativeMap = nativeMap;
    }

    @Deprecated
    public String getUrl() {
        validateState("getUrl");
        return this.nativeMap.getStyleUri();
    }

    public String getUri() {
        validateState("getUri");
        return this.nativeMap.getStyleUri();
    }

    public String getJson() {
        validateState("getJson");
        return this.nativeMap.getStyleJson();
    }

    public List<Source> getSources() {
        validateState("getSources");
        return this.nativeMap.getSources();
    }

    public void addSource(Source source) {
        validateState("addSource");
        this.nativeMap.addSource(source);
        this.sources.put(source.getId(), source);
    }

    public Source getSource(String str) {
        validateState("getSource");
        Source source = this.sources.get(str);
        return source == null ? this.nativeMap.getSource(str) : source;
    }

    public <T extends Source> T getSourceAs(String str) {
        validateState("getSourceAs");
        if (this.sources.containsKey(str)) {
            return (T) this.sources.get(str);
        }
        return (T) this.nativeMap.getSource(str);
    }

    public boolean removeSource(String str) {
        validateState("removeSource");
        this.sources.remove(str);
        return this.nativeMap.removeSource(str);
    }

    public boolean removeSource(Source source) {
        validateState("removeSource");
        this.sources.remove(source.getId());
        return this.nativeMap.removeSource(source);
    }

    public void addLayer(Layer layer) {
        validateState("addLayer");
        this.nativeMap.addLayer(layer);
        this.layers.put(layer.getId(), layer);
    }

    public void addLayerBelow(Layer layer, String str) {
        validateState("addLayerBelow");
        this.nativeMap.addLayerBelow(layer, str);
        this.layers.put(layer.getId(), layer);
    }

    public void addLayerAbove(Layer layer, String str) {
        validateState("addLayerAbove");
        this.nativeMap.addLayerAbove(layer, str);
        this.layers.put(layer.getId(), layer);
    }

    public void addLayerAt(Layer layer, int i) {
        validateState("addLayerAbove");
        this.nativeMap.addLayerAt(layer, i);
        this.layers.put(layer.getId(), layer);
    }

    public Layer getLayer(String str) {
        validateState("getLayer");
        Layer layer = this.layers.get(str);
        return layer == null ? this.nativeMap.getLayer(str) : layer;
    }

    public <T extends Layer> T getLayerAs(String str) {
        validateState("getLayerAs");
        return (T) this.nativeMap.getLayer(str);
    }

    public List<Layer> getLayers() {
        validateState("getLayers");
        return this.nativeMap.getLayers();
    }

    public boolean removeLayer(String str) {
        validateState("removeLayer");
        this.layers.remove(str);
        return this.nativeMap.removeLayer(str);
    }

    public boolean removeLayer(Layer layer) {
        validateState("removeLayer");
        this.layers.remove(layer.getId());
        return this.nativeMap.removeLayer(layer);
    }

    public boolean removeLayerAt(int i) {
        validateState("removeLayerAt");
        return this.nativeMap.removeLayerAt(i);
    }

    public void addImage(String str, Bitmap bitmap) {
        addImage(str, bitmap, false);
    }

    public void addImage(String str, Bitmap bitmap, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        addImage(str, bitmap, false, list, list2, imageContent);
    }

    public void addImage(String str, Drawable drawable) {
        Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
        if (bitmapFromDrawable == null) {
            throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
        }
        addImage(str, bitmapFromDrawable, false);
    }

    public void addImage(String str, Drawable drawable, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
        if (bitmapFromDrawable == null) {
            throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
        }
        addImage(str, bitmapFromDrawable, false, list, list2, imageContent);
    }

    public void addImage(String str, Bitmap bitmap, boolean z) {
        validateState("addImage");
        this.nativeMap.addImages(new Image[]{toImage(new Builder.ImageWrapper(str, bitmap, z))});
    }

    public void addImage(String str, Bitmap bitmap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        validateState("addImage");
        this.nativeMap.addImages(new Image[]{toImage(new Builder.ImageWrapper(str, bitmap, z, list, list2, imageContent))});
    }

    public void addImageAsync(String str, Bitmap bitmap) {
        addImageAsync(str, bitmap, false);
    }

    public void addImageAsync(String str, Bitmap bitmap, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        addImageAsync(str, bitmap, false, list, list2, imageContent);
    }

    public void addImageAsync(String str, Drawable drawable) {
        Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
        if (bitmapFromDrawable == null) {
            throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
        }
        addImageAsync(str, bitmapFromDrawable, false);
    }

    public void addImageAsync(String str, Drawable drawable, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
        if (bitmapFromDrawable == null) {
            throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
        }
        addImageAsync(str, bitmapFromDrawable, false, list, list2, imageContent);
    }

    public void addImageAsync(String str, Bitmap bitmap, boolean z) {
        validateState("addImage");
        new BitmapImageConversionTask(this.nativeMap).execute(new Builder.ImageWrapper(str, bitmap, z));
    }

    public void addImageAsync(String str, Bitmap bitmap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        validateState("addImage");
        new BitmapImageConversionTask(this.nativeMap).execute(new Builder.ImageWrapper(str, bitmap, z, list, list2, imageContent));
    }

    public void addImages(HashMap<String, Bitmap> hashMap) {
        addImages(hashMap, false);
    }

    public void addImages(HashMap<String, Bitmap> hashMap, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        addImages(hashMap, false, list, list2, imageContent);
    }

    public void addImages(HashMap<String, Bitmap> hashMap, boolean z) {
        validateState("addImage");
        Image[] imageArr = new Image[hashMap.size()];
        int i = 0;
        for (Builder.ImageWrapper imageWrapper : Builder.ImageWrapper.convertToImageArray(hashMap, z)) {
            imageArr[i] = toImage(imageWrapper);
            i++;
        }
        this.nativeMap.addImages(imageArr);
    }

    public void addImages(HashMap<String, Bitmap> hashMap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        validateState("addImage");
        Image[] imageArr = new Image[hashMap.size()];
        Builder.ImageWrapper[] convertToImageArray = Builder.ImageWrapper.convertToImageArray(hashMap, z, list, list2, imageContent);
        int i = 0;
        for (Builder.ImageWrapper imageWrapper : convertToImageArray) {
            imageArr[i] = toImage(imageWrapper);
            i++;
        }
        this.nativeMap.addImages(imageArr);
    }

    public void addImagesAsync(HashMap<String, Bitmap> hashMap) {
        addImagesAsync(hashMap, false);
    }

    public void addImagesAsync(HashMap<String, Bitmap> hashMap, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        addImagesAsync(hashMap, false, list, list2, imageContent);
    }

    public void addImagesAsync(HashMap<String, Bitmap> hashMap, boolean z) {
        validateState("addImages");
        new BitmapImageConversionTask(this.nativeMap).execute(Builder.ImageWrapper.convertToImageArray(hashMap, z));
    }

    public void addImagesAsync(HashMap<String, Bitmap> hashMap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
        validateState("addImages");
        new BitmapImageConversionTask(this.nativeMap).execute(Builder.ImageWrapper.convertToImageArray(hashMap, z, list, list2, imageContent));
    }

    public void addImages(Image[] imageArr) {
        validateState("addImages");
        this.nativeMap.addImages(imageArr);
    }

    public void removeImage(String str) {
        validateState("removeImage");
        this.nativeMap.removeImage(str);
    }

    public Bitmap getImage(String str) {
        validateState("getImage");
        return this.nativeMap.getImage(str);
    }

    public void setTransition(TransitionOptions transitionOptions) {
        validateState("setTransition");
        this.nativeMap.setTransitionOptions(transitionOptions);
    }

    public TransitionOptions getTransition() {
        validateState("getTransition");
        return this.nativeMap.getTransitionOptions();
    }

    public Light getLight() {
        validateState("getLight");
        return this.nativeMap.getLight();
    }

    void clear() {
        this.fullyLoaded = false;
        for (Layer layer : this.layers.values()) {
            if (layer != null) {
                layer.setDetached();
            }
        }
        for (Source source : this.sources.values()) {
            if (source != null) {
                source.setDetached();
            }
        }
        for (Map.Entry<String, Bitmap> entry : this.images.entrySet()) {
            this.nativeMap.removeImage(entry.getKey());
            entry.getValue().recycle();
        }
        this.sources.clear();
        this.layers.clear();
        this.images.clear();
    }

    void onDidFinishLoadingStyle() {
        if (this.fullyLoaded) {
            return;
        }
        this.fullyLoaded = true;
        Iterator it = this.builder.sources.iterator();
        while (it.hasNext()) {
            addSource((Source) it.next());
        }
        for (Builder.LayerWrapper layerWrapper : this.builder.layers) {
            if (layerWrapper instanceof Builder.LayerAtWrapper) {
                addLayerAt(layerWrapper.layer, ((Builder.LayerAtWrapper) layerWrapper).index);
            } else if (layerWrapper instanceof Builder.LayerAboveWrapper) {
                addLayerAbove(layerWrapper.layer, ((Builder.LayerAboveWrapper) layerWrapper).aboveLayer);
            } else if (layerWrapper instanceof Builder.LayerBelowWrapper) {
                addLayerBelow(layerWrapper.layer, ((Builder.LayerBelowWrapper) layerWrapper).belowLayer);
            } else {
                addLayerBelow(layerWrapper.layer, MapboxConstants.LAYER_ID_ANNOTATIONS);
            }
        }
        for (Builder.ImageWrapper imageWrapper : this.builder.images) {
            addImage(imageWrapper.f2704id, imageWrapper.bitmap, imageWrapper.sdf);
        }
        if (this.builder.transitionOptions != null) {
            setTransition(this.builder.transitionOptions);
        }
    }

    public boolean isFullyLoaded() {
        return this.fullyLoaded;
    }

    private void validateState(String str) {
        if (!this.fullyLoaded) {
            throw new IllegalStateException(String.format("Calling %s when a newer style is loading/has loaded.", str));
        }
    }

    public static class Builder {
        private String styleJson;
        private String styleUri;
        private TransitionOptions transitionOptions;
        private final List<Source> sources = new ArrayList();
        private final List<LayerWrapper> layers = new ArrayList();
        private final List<ImageWrapper> images = new ArrayList();

        @Deprecated
        public Builder fromUrl(String str) {
            this.styleUri = str;
            return this;
        }

        public Builder fromUri(String str) {
            this.styleUri = str;
            return this;
        }

        public Builder fromJson(String str) {
            this.styleJson = str;
            return this;
        }

        public Builder withSource(Source source) {
            this.sources.add(source);
            return this;
        }

        public Builder withSources(Source... sourceArr) {
            this.sources.addAll(Arrays.asList(sourceArr));
            return this;
        }

        public Builder withLayer(Layer layer) {
            this.layers.add(new LayerWrapper(layer));
            return this;
        }

        public Builder withLayers(Layer... layerArr) {
            for (Layer layer : layerArr) {
                this.layers.add(new LayerWrapper(layer));
            }
            return this;
        }

        public Builder withLayerAt(Layer layer, int i) {
            this.layers.add(new LayerAtWrapper(layer, i));
            return this;
        }

        public Builder withLayerAbove(Layer layer, String str) {
            this.layers.add(new LayerAboveWrapper(layer, str));
            return this;
        }

        public Builder withLayerBelow(Layer layer, String str) {
            this.layers.add(new LayerBelowWrapper(layer, str));
            return this;
        }

        public Builder withTransition(TransitionOptions transitionOptions) {
            this.transitionOptions = transitionOptions;
            return this;
        }

        public Builder withImage(String str, Drawable drawable) {
            Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
            if (bitmapFromDrawable == null) {
                throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
            }
            return withImage(str, bitmapFromDrawable, false);
        }

        public Builder withImage(String str, Drawable drawable, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
            Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
            if (bitmapFromDrawable == null) {
                throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
            }
            return withImage(str, bitmapFromDrawable, false, list, list2, imageContent);
        }

        public Builder withDrawableImages(Pair<String, Drawable>... pairArr) {
            return withDrawableImages(false, pairArr);
        }

        public Builder withImage(String str, Bitmap bitmap) {
            return withImage(str, bitmap, false);
        }

        public Builder withImage(String str, Bitmap bitmap, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
            return withImage(str, bitmap, false, list, list2, imageContent);
        }

        public Builder withBitmapImages(Pair<String, Bitmap>... pairArr) {
            for (Pair<String, Bitmap> pair : pairArr) {
                withImage((String) pair.first, (Bitmap) pair.second, false);
            }
            return this;
        }

        public Builder withImage(String str, Drawable drawable, boolean z) {
            Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
            if (bitmapFromDrawable == null) {
                throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
            }
            return withImage(str, bitmapFromDrawable, z);
        }

        public Builder withImage(String str, Drawable drawable, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
            Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable(drawable);
            if (bitmapFromDrawable == null) {
                throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
            }
            return withImage(str, bitmapFromDrawable, z, list, list2, imageContent);
        }

        public Builder withDrawableImages(boolean z, Pair<String, Drawable>... pairArr) {
            for (Pair<String, Drawable> pair : pairArr) {
                Bitmap bitmapFromDrawable = BitmapUtils.getBitmapFromDrawable((Drawable) pair.second);
                if (bitmapFromDrawable == null) {
                    throw new IllegalArgumentException("Provided drawable couldn't be converted to a Bitmap.");
                }
                withImage((String) pair.first, bitmapFromDrawable, z);
            }
            return this;
        }

        public Builder withImage(String str, Bitmap bitmap, boolean z) {
            this.images.add(new ImageWrapper(str, bitmap, z));
            return this;
        }

        public Builder withImage(String str, Bitmap bitmap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
            this.images.add(new ImageWrapper(str, bitmap, z, list, list2, imageContent));
            return this;
        }

        public Builder withBitmapImages(boolean z, Pair<String, Bitmap>... pairArr) {
            for (Pair<String, Bitmap> pair : pairArr) {
                withImage((String) pair.first, (Bitmap) pair.second, z);
            }
            return this;
        }

        public String getUri() {
            return this.styleUri;
        }

        public String getJson() {
            return this.styleJson;
        }

        public List<Source> getSources() {
            return this.sources;
        }

        public List<LayerWrapper> getLayers() {
            return this.layers;
        }

        public List<ImageWrapper> getImages() {
            return this.images;
        }

        TransitionOptions getTransitionOptions() {
            return this.transitionOptions;
        }

        Style build(NativeMap nativeMap) {
            return new Style(this, nativeMap);
        }

        public static class ImageWrapper {
            Bitmap bitmap;
            ImageContent content;

            /* renamed from: id */
            String f2704id;
            boolean sdf;
            List<ImageStretches> stretchX;
            List<ImageStretches> stretchY;

            public ImageWrapper(String str, Bitmap bitmap, boolean z) {
                this(str, bitmap, z, null, null, null);
            }

            public ImageWrapper(String str, Bitmap bitmap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
                this.f2704id = str;
                this.bitmap = bitmap;
                this.sdf = z;
                this.stretchX = list;
                this.stretchY = list2;
                this.content = imageContent;
            }

            public Bitmap getBitmap() {
                return this.bitmap;
            }

            public String getId() {
                return this.f2704id;
            }

            public boolean isSdf() {
                return this.sdf;
            }

            public List<ImageStretches> getStretchX() {
                return this.stretchX;
            }

            public List<ImageStretches> getStretchY() {
                return this.stretchY;
            }

            public ImageContent getContent() {
                return this.content;
            }

            public static ImageWrapper[] convertToImageArray(HashMap<String, Bitmap> hashMap, boolean z) {
                ImageWrapper[] imageWrapperArr = new ImageWrapper[hashMap.size()];
                ArrayList arrayList = new ArrayList(hashMap.keySet());
                for (int i = 0; i < hashMap.size(); i++) {
                    String str = (String) arrayList.get(i);
                    imageWrapperArr[i] = new ImageWrapper(str, hashMap.get(str), z);
                }
                return imageWrapperArr;
            }

            public static ImageWrapper[] convertToImageArray(HashMap<String, Bitmap> hashMap, boolean z, List<ImageStretches> list, List<ImageStretches> list2, ImageContent imageContent) {
                ImageWrapper[] imageWrapperArr = new ImageWrapper[hashMap.size()];
                ArrayList arrayList = new ArrayList(hashMap.keySet());
                for (int i = 0; i < hashMap.size(); i++) {
                    String str = (String) arrayList.get(i);
                    imageWrapperArr[i] = new ImageWrapper(str, hashMap.get(str), z, list, list2, imageContent);
                }
                return imageWrapperArr;
            }
        }

        public class LayerWrapper {
            Layer layer;

            LayerWrapper(Layer layer) {
                this.layer = layer;
            }

            public Layer getLayer() {
                return this.layer;
            }
        }

        public class LayerAboveWrapper extends LayerWrapper {
            String aboveLayer;

            LayerAboveWrapper(Layer layer, String str) {
                super(layer);
                this.aboveLayer = str;
            }

            public String getAboveLayer() {
                return this.aboveLayer;
            }
        }

        public class LayerBelowWrapper extends LayerWrapper {
            String belowLayer;

            LayerBelowWrapper(Layer layer, String str) {
                super(layer);
                this.belowLayer = str;
            }

            public String getBelowLayer() {
                return this.belowLayer;
            }
        }

        public class LayerAtWrapper extends LayerWrapper {
            int index;

            LayerAtWrapper(Layer layer, int i) {
                super(layer);
                this.index = i;
            }

            public int getIndex() {
                return this.index;
            }
        }
    }

    public static Image toImage(Builder.ImageWrapper imageWrapper) {
        Bitmap bitmap = imageWrapper.bitmap;
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        float density = bitmap.getDensity() / 160.0f;
        if (imageWrapper.getStretchX() != null && imageWrapper.getStretchY() != null) {
            float[] fArr = new float[imageWrapper.getStretchX().size() * 2];
            for (int i = 0; i < imageWrapper.getStretchX().size(); i++) {
                int i2 = i * 2;
                fArr[i2] = imageWrapper.getStretchX().get(i).getFirst();
                fArr[i2 + 1] = imageWrapper.getStretchX().get(i).getSecond();
            }
            float[] fArr2 = new float[imageWrapper.getStretchY().size() * 2];
            for (int i3 = 0; i3 < imageWrapper.getStretchY().size(); i3++) {
                int i4 = i3 * 2;
                fArr2[i4] = imageWrapper.getStretchY().get(i3).getFirst();
                fArr2[i4 + 1] = imageWrapper.getStretchY().get(i3).getSecond();
            }
            return new Image(allocate.array(), density, imageWrapper.f2704id, bitmap.getWidth(), bitmap.getHeight(), imageWrapper.sdf, fArr, fArr2, imageWrapper.getContent() == null ? null : imageWrapper.getContent().getContentArray());
        }
        return new Image(allocate.array(), density, imageWrapper.f2704id, bitmap.getWidth(), bitmap.getHeight(), imageWrapper.sdf);
    }

    private static class BitmapImageConversionTask extends AsyncTask<Builder.ImageWrapper, Void, Image[]> {
        private WeakReference<NativeMap> nativeMap;

        BitmapImageConversionTask(NativeMap nativeMap) {
            this.nativeMap = new WeakReference<>(nativeMap);
        }

        @Override // android.os.AsyncTask
        protected Image[] doInBackground(Builder.ImageWrapper... imageWrapperArr) {
            ArrayList arrayList = new ArrayList();
            for (Builder.ImageWrapper imageWrapper : imageWrapperArr) {
                arrayList.add(Style.toImage(imageWrapper));
            }
            return (Image[]) arrayList.toArray(new Image[arrayList.size()]);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Image[] imageArr) {
            super.onPostExecute((BitmapImageConversionTask) imageArr);
            NativeMap nativeMap = this.nativeMap.get();
            if (nativeMap == null || nativeMap.isDestroyed()) {
                return;
            }
            nativeMap.addImages(imageArr);
        }
    }
}