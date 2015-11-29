package vaibhav.com.heterolistings.core.templates;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * Each item that resides in HeterViewsAdapter must implement this interface.
 */
public interface TemplateItemManager<T extends RecyclerView.ViewHolder> {

    /**
     * Binds data with view
     * @param holder: holder to which data is to be attached
     */
    void bindViewHolder(T holder);

    /**
     *
     * @return: TemplateType id of the template manager
     */
    int getItemType();
}
