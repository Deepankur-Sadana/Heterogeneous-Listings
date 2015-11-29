package vaibhav.com.heterolistings.templatemanagers.type1;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

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

    public Type1Manager(BundleData data) {
        this.data = data;
    }

    static public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = TemplateProvider.getTemplateView(parent, TemplateType.TYPE1);
        return new Type1ViewHolder(view);
    }

    @Override
    public void bindViewHolder(Type1ViewHolder holder) {
        if (holder instanceof Type1ViewHolder) {
            ((Type1ViewHolder) holder).setImage(data.items.get(0).imageUrl);
        }
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
        }

        private void setImage(String imageUrl) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisk(true)
                    .displayer(new FadeInBitmapDisplayer(300))
                    .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                    .bitmapConfig(Bitmap.Config.RGB_565).build();

            ImageLoader.getInstance().displayImage(imageUrl, imageView, options);
        }
    }
}
