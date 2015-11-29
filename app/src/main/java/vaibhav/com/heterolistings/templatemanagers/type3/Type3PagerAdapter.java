package vaibhav.com.heterolistings.templatemanagers.type3;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import vaibhav.com.heterolistings.core.templates.TemplateProvider;
import vaibhav.com.heterolistings.data.BundleData;

/**
 * Created by Vaibhav on 11/29/15.
 */
class Type3PagerAdapter extends PagerAdapter {

    private ArrayList<BundleData.BundleItem> items;
    private DisplayImageOptions displayImageOptions;

    protected Type3PagerAdapter(ArrayList<BundleData.BundleItem> items) {
        this.items = items;
        displayImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new FadeInBitmapDisplayer(300))
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == ((View) o);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = TemplateProvider.getFitWidthImageView(container);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        ImageLoader.getInstance().displayImage(items.get(position).imageUrl, imageView, displayImageOptions);

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

//    @Override
//    public int getIconResId(int i) {
//        return R.drawable.indicator;
//    }
}
