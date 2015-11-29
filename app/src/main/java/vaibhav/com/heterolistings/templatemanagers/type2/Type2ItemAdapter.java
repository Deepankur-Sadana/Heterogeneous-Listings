package vaibhav.com.heterolistings.templatemanagers.type2;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.data.BundleData;

/**
 * Created by Vaibhav on 11/29/15.
 */
class Type2ItemAdapter extends RecyclerView.Adapter<Type2ItemAdapter.Type2ItemViewHolder> {

    private ArrayList<BundleData.BundleItem> items;
    DisplayImageOptions displayImageOptions;

    protected Type2ItemAdapter(ArrayList<BundleData.BundleItem> items) {
        this.items = items;
        displayImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new FadeInBitmapDisplayer(300))
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    @Override
    public void onBindViewHolder(Type2ItemViewHolder holder, int position) {
        ImageView imageView = holder.getImageView();

        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        ImageLoader.getInstance().displayImage(items.get(position).imageUrl, imageView, displayImageOptions);
    }

    @Override
    public Type2ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_view, parent, false);
        return new Type2ItemViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class Type2ItemViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private ImageView imageView;

        Type2ItemViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.imageView = (ImageView) itemView.findViewById(R.id.image_fit_width);
        }

        protected ImageView getImageView() {
            return imageView;
        }

    }
}
