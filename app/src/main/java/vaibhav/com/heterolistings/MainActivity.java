package vaibhav.com.heterolistings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import vaibhav.com.heterolistings.core.TemplateItemManager;
import vaibhav.com.heterolistings.templatemanagers.Type1Manager;
import vaibhav.com.heterolistings.templatemanagers.Type2Manager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView parentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentRecyclerView = (RecyclerView)findViewById(R.id.parent_recycler_view);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // TODO: Remove this test code
        String dataType1 = "Type 1 Data";
        String dataType2 = "Type 2 Data";

        ArrayList<TemplateItemManager> templateItemManagers = new ArrayList<>();

        for (int i = 0; i< 100 ; i++) {
            templateItemManagers.add(new Type1Manager(dataType1));
            templateItemManagers.add(new Type2Manager(dataType2));
        }
        // Test code ends
        
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
