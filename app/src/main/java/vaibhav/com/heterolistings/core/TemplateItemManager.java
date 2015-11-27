package vaibhav.com.heterolistings.core;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Vaibhav on 11/27/15.
 */
public interface TemplateItemManager {

    void bindViewHolder(RecyclerView.ViewHolder holder);

    int getItemType();
}
