package vaibhav.com.heterolistings;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import vaibhav.com.heterolistings.core.BaseRecyclerViewAdapter;
import vaibhav.com.heterolistings.core.TemplateItemManager;
import vaibhav.com.heterolistings.core.TemplateType;
import vaibhav.com.heterolistings.templatemanagers.Type1Manager;
import vaibhav.com.heterolistings.templatemanagers.Type2Manager;

/**
 * Created by Vaibhav on 11/27/15.
 */
public class HeteroViewsAdapter extends BaseRecyclerViewAdapter {

    private ArrayList<TemplateItemManager> templateItemManagers;

    HeteroViewsAdapter(ArrayList<TemplateItemManager> templateItemManagers) {
        this.templateItemManagers = templateItemManagers;
    }

    @Override
    public int getItemViewType(int position) {
        return templateItemManagers.get(position).getItemType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == TemplateType.TYPE1.getId())
            holder = Type1Manager.createViewHolder(parent);
        else if (viewType == TemplateType.TYPE2.getId())
            holder = Type2Manager.createViewHolder(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        templateItemManagers.get(position).bindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return templateItemManagers.size();
    }
}
