package vaibhav.com.heterolistings.templatemanagers.type1;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.core.templates.TemplateItemManager;
import vaibhav.com.heterolistings.core.templates.TemplateProvider;
import vaibhav.com.heterolistings.core.templates.TemplateType;
import vaibhav.com.heterolistings.data.BundleData;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * Manager class for Template type 1. Any interaction with type 1 template must be done via this class.
 */
public class Type1Manager implements TemplateItemManager<Type1Manager.Type1ViewHolder> {

    private BundleData data;
    final private DisplayMetrics displayMetrics;

    public Type1Manager(final DisplayMetrics displayMetrics, BundleData data) {
        this.data = data;
        this.displayMetrics = displayMetrics;
    }

    static public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = TemplateProvider.getTemplateView(parent, TemplateType.TYPE1);
        Type1ViewHolder type1ViewHolder = new Type1ViewHolder(view);
        return type1ViewHolder;
    }

    @Override
    public void bindViewHolder(Type1ViewHolder holder) {
        ImageView imageView = holder.getImageView();
        setImageAndLayout(imageView);
    }

    private void setImageAndLayout(ImageView imageView) {
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();

        BundleData.BundleItem item = data.items.get(0);

        ImageLoader.getInstance().displayImage(item.imageUrl, imageView, options);

        int scaledHeight = displayMetrics.widthPixels/item.width * item.height;
        imageView.getLayoutParams().width = displayMetrics.widthPixels;
        imageView.getLayoutParams().height = scaledHeight;
    }

    @Override
    public int getItemType() {
        return TemplateType.TYPE1.getId();
    }

    static class Type1ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        View itemView;

        private Type1ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.imageView = (ImageView)itemView.findViewById(R.id.image_fit_width);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        private ImageView getImageView() {
            return imageView;
        }

    }
}
