package vaibhav.com.heterolistings.templatemanagers.type2;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.core.templates.TemplateItemManager;
import vaibhav.com.heterolistings.core.templates.TemplateProvider;
import vaibhav.com.heterolistings.core.templates.TemplateType;
import vaibhav.com.heterolistings.data.BundleData;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * Manager class for Template type 2. Any interaction with type 2 template must be done via this class.
 */
public class Type2Manager implements TemplateItemManager<Type2Manager.Type2ViewHolder> {

    private BundleData data;
    private Context context;
    private DisplayMetrics displayMetrics;

    public Type2Manager(Context context, DisplayMetrics displayMetrics, BundleData data) {
        this.data = data;
        this.context = context;
        this.displayMetrics = displayMetrics;
    }

    static public Type2ViewHolder createViewHolder(ViewGroup parent) {
        View view = TemplateProvider.getTemplateView(parent, TemplateType.TYPE2);
        return new Type2ViewHolder(view);
    }

    @Override
    public void bindViewHolder(Type2ViewHolder holder) {
        RecyclerView recyclerView = holder.getRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        Type2ItemAdapter type2ItemAdapter = new Type2ItemAdapter(displayMetrics, data.items);
        recyclerView.getLayoutParams().height = getMaxScaledHeightWiththirdOfScreenWidth();
        recyclerView.setAdapter(type2ItemAdapter);
    }

    @Override
    public int getItemType() {
        return TemplateType.TYPE2.getId();
    }

    private int getMaxScaledHeightWiththirdOfScreenWidth() {
        int maxHeight = 0;
        for (BundleData.BundleItem item : data.items) {
            int currentScaledHeight =  (displayMetrics.widthPixels/3)/item.width * item.height;
            maxHeight = Math.max(currentScaledHeight, maxHeight);
        }
        return maxHeight;
    }

    static class Type2ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        RecyclerView itemRecyclerView;

        public Type2ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemRecyclerView = (RecyclerView) itemView.findViewById(R.id.item_recycler_view);
        }

        private RecyclerView getRecyclerView() {
            return itemRecyclerView;
        }
    }
}
