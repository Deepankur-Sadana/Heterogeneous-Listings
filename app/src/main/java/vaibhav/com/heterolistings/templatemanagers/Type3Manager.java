package vaibhav.com.heterolistings.templatemanagers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.core.templates.TemplateItemManager;
import vaibhav.com.heterolistings.core.templates.TemplateProvider;
import vaibhav.com.heterolistings.core.templates.TemplateType;

/**
 * Created by Vaibhav on 11/29/15.
 *
 * Manager class for Template type 3. Any interaction with type 3 template must be done via this class.
 */
public class Type3Manager implements TemplateItemManager {

    private String data;

    public Type3Manager(String data) {
        this.data = data;
    }

    static public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = TemplateProvider.getTemplateView(parent, TemplateType.TYPE3);
        return new Type3ViewHolder(view);
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        if (holder instanceof Type3ViewHolder) {
            ((Type3ViewHolder) holder).setText(data);
        }
    }

    @Override
    public int getItemType() {
        return TemplateType.TYPE3.getId();
    }

    private static class Type3ViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        public Type3ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        private void setText(String text) {
            TextView textView = (TextView)itemView.findViewById(R.id.textView);
            textView.setText(text);
        }
    }
}
