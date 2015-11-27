package vaibhav.com.heterolistings.templatemanagers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.core.TemplateItemManager;
import vaibhav.com.heterolistings.core.TemplateProvider;
import vaibhav.com.heterolistings.core.TemplateType;

/**
 * Created by Vaibhav on 11/27/15.
 */
public class Type2Manager implements TemplateItemManager {

    private String data;

    public Type2Manager(String data) {
        this.data = data;
    }

    static public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = TemplateProvider.getTemplateView(parent, TemplateType.TYPE2);
        return new Type2ViewHolder(view);
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        if (holder instanceof Type2ViewHolder) {
            ((Type2ViewHolder) holder).setText(data);
        }
    }

    @Override
    public int getItemType() {
        return TemplateType.TYPE2.getId();
    }

    private static class Type2ViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        public Type2ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        private void setText(String text) {
            TextView textView = (TextView)itemView.findViewById(R.id.textView);
            textView.setText(text);
        }
    }
}
