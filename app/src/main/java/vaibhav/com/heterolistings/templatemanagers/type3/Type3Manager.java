package vaibhav.com.heterolistings.templatemanagers.type3;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.core.templates.TemplateItemManager;
import vaibhav.com.heterolistings.core.templates.TemplateProvider;
import vaibhav.com.heterolistings.core.templates.TemplateType;
import vaibhav.com.heterolistings.data.BundleData;

/**
 * Created by Vaibhav on 11/29/15.
 *
 * Manager class for Template type 3. Any interaction with type 3 template must be done via this class.
 */
public class Type3Manager implements TemplateItemManager<Type3Manager.Type3ViewHolder> {

    private BundleData data;

    public Type3Manager(BundleData data) {
        this.data = data;
    }

    static public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = TemplateProvider.getTemplateView(parent, TemplateType.TYPE3);
        return new Type3ViewHolder(view);
    }

    @Override
    public void bindViewHolder(Type3ViewHolder holder) {
        ViewPager viewPager = holder.getViewPager();
        Type3PagerAdapter type3PagerAdapter = new Type3PagerAdapter(data.items);
        viewPager.setAdapter(type3PagerAdapter);
    }

    @Override
    public int getItemType() {
        return TemplateType.TYPE3.getId();
    }

    static class Type3ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ViewPager viewPager;

        public Type3ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.viewPager = (ViewPager) itemView.findViewById(R.id.photo_pager);
        }

        private ViewPager getViewPager() {
            return viewPager;
        }
    }
}
