package vaibhav.com.heterolistings.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vaibhav.com.heterolistings.R;

/**
 * Created by Vaibhav on 11/27/15.
 */
public class TemplateProvider {

    static public View getTemplateView(ViewGroup parent, TemplateType type) {
        View templateView = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (type.getId()) {
            case 1:
                templateView = inflater.inflate(R.layout.layout_template_1, parent, false);
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
}
