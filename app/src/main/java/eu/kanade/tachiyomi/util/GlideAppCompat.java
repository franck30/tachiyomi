package eu.kanade.tachiyomi.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;

import eu.kanade.tachiyomi.data.glide.GlideApp;
import eu.kanade.tachiyomi.data.glide.GlideRequest;
import eu.kanade.tachiyomi.data.glide.GlideRequests;

public class GlideAppCompat {
    public static GlideRequestsCompat with(Context context) {
        return new GlideRequestsCompat(GlideApp.with(context));
    }

    public static GlideRequestsCompat with(View view) {
        return new GlideRequestsCompat(GlideApp.with(view));
    }

    public static class GlideRequestsCompat {
        private final GlideRequests requests;

        private GlideRequestsCompat(GlideRequests requests) {
            this.requests = requests;
        }

        public void clear(View view) {
            requests.clear(view);
        }

        public GlideRequestCompat<Drawable> load(Object obj) {
            return new GlideRequestCompat<>(requests.load(obj));
        }

        public GlideRequestCompat<Bitmap> asBitmap() {
            return new GlideRequestCompat<>(requests.asBitmap());
        }
    }

    public static class GlideRequestCompat<TranscodeType> {
        private final GlideRequest<TranscodeType> request;

        private GlideRequestCompat(GlideRequest<TranscodeType> request) {
            this.request = request;
        }

        public GlideRequestCompat<TranscodeType> load(Object obj) {
            request.load(obj);
            return this;
        }

        public GlideRequestCompat<TranscodeType> diskCacheStrategy(DiskCacheStrategy strategy) {
            request.diskCacheStrategy(strategy);
            return this;
        }

        public GlideRequestCompat<TranscodeType> centerCrop() {
            request.centerCrop();
            return this;
        }

        public GlideRequestCompat<TranscodeType> circleCrop() {
            request.circleCrop();
            return this;
        }

        public GlideRequestCompat<TranscodeType> dontAnimate() {
            request.dontAnimate();
            return this;
        }

        public GlideRequestCompat<TranscodeType> transform(Transformation<Bitmap> transformation) {
            request.transform(transformation);
            return this;
        }

        public GlideRequestCompat<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> options) {
            request.transition(options);
            return this;
        }

        public GlideRequestCompat<TranscodeType> listener(RequestListener<TranscodeType> listener) {
            request.listener(listener);
            return this;
        }

        public GlideRequestCompat<TranscodeType> skipMemoryCache(boolean skip) {
            request.skipMemoryCache(skip);
            return this;
        }

        public GlideRequestCompat<TranscodeType> placeholder(int resource) {
            request.placeholder(resource);
            return this;
        }

        public <Y extends Target<TranscodeType>> Y into(Y target) {
            return request.into(target);
        }

        public ViewTarget<ImageView, TranscodeType> into(ImageView target) {
            return request.into(target);
        }

        public FutureTarget<TranscodeType> submit(int width, int height) {
            return request.submit(width, height);
        }
    }
}