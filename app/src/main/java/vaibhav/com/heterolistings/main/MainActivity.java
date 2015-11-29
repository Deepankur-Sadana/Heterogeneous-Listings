package vaibhav.com.heterolistings.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import vaibhav.com.heterolistings.R;
import vaibhav.com.heterolistings.core.templates.TemplateItemManager;
import vaibhav.com.heterolistings.core.templates.TemplateProvider;
import vaibhav.com.heterolistings.core.templates.TemplateType;
import vaibhav.com.heterolistings.data.BundleData;
import vaibhav.com.heterolistings.data.DataProvider;
import vaibhav.com.heterolistings.templatemanagers.type1.Type1Manager;
import vaibhav.com.heterolistings.templatemanagers.type3.Type3Manager;
import vaibhav.com.heterolistings.templatemanagers.type2.Type2Manager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView parentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!ImageLoader.getInstance().isInited())
            TemplateProvider.initImageLoader(this);

        parentRecyclerView = (RecyclerView)findViewById(R.id.parent_recycler_view);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<BundleData> bundleFeed = DataProvider.getData();

        ArrayList<TemplateItemManager> templateItemManagers = new ArrayList<>();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        for (BundleData bundleData : bundleFeed) {
            if (bundleData.template.equals(TemplateType.TYPE1.getName()))
                templateItemManagers.add(new Type1Manager(displayMetrics, bundleData));
            else if (bundleData.template.equals(TemplateType.TYPE2.getName()))
                templateItemManagers.add(new Type2Manager(this, displayMetrics, bundleData));
            else if (bundleData.template.equals(TemplateType.TYPE3.getName()))
                templateItemManagers.add(new Type3Manager(displayMetrics, bundleData));
        }

        HeteroViewsAdapter heteroViewsAdapter = new HeteroViewsAdapter(templateItemManagers);
        parentRecyclerView.setAdapter(heteroViewsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
