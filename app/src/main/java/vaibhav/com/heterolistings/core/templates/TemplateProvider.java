package vaibhav.com.heterolistings.core.templates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import vaibhav.com.heterolistings.R;

/**
 * Created by Vaibhav on 11/27/15.
 * Central class that manages views for each template type.
 */
public class TemplateProvider {

    /**
     * Every app component that requires view for a given template should invoke this method.
     * @param parent: parent viewgroup of the template view
     * @param type: Type of template. Enum TemplateType
     * @return
     */
    static public View getTemplateView(ViewGroup parent, TemplateType type) {
        View templateView = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (type.getId()) {
            case 1:
                templateView = getFitWidthImageView(parent);
                break;
            case 2:
                templateView = inflater.inflate(R.layout.layout_template_2, parent, false);
                break;
            case 3:
                templateView = inflater.inflate(R.layout.layout_template_3, parent, false);
                break;
        }
        return templateView;
    }

    public static void initImageLoader(Context context) {

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                .memoryCacheSize(4 * 1024 * 1024)
                .diskCacheSize(15 * 1024 * 1024)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build();

        ImageLoader.getInstance().init(config);
    }

    static public ImageView getFitWidthImageView(ViewGroup parent) {
        return  (ImageView)LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_view, parent, false);
    }

}
