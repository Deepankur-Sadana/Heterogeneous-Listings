package vaibhav.com.heterolistings.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import vaibhav.com.heterolistings.R;

/**
 * Created by Vaibhav on 11/27/15.
 */
public class TemplateProvider {

    static View getTemplateView(Context context, TemplateType type) {
        View templateView = null;
        switch (type.getId()) {
            case 1:
                templateView = LayoutInflater.from(context).inflate(R.layout.layout_template_1, null);
                break;
            case 2:
                templateView = LayoutInflater.from(context).inflate(R.layout.layout_template_2, null);
                break;
            case 3:
                templateView = LayoutInflater.from(context).inflate(R.layout.layout_template_3, null);
                break;
        }
        return templateView;
    }
}
