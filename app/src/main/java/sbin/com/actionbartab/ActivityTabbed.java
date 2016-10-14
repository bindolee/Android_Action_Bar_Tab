package sbin.com.actionbartab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


/**
 * Created by IntelliJ IDEA.
 * User: Jim
 * Date: 6/13/12
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivityTabbed extends AppCompatActivity {
    private static final String LOG_TAG = "ActivityTabbed";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        // Set toolbar to support activity_tabbed.xml -
        // this supports android.support.design.widget.AppBarLayout and android.support.v7.widget.Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tabbed);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Tabbed Action Bar - sbin");

        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab_control, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menuToggleTitle:
                Toast.makeText(this,"Activity's Menu toggle clicked",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        return true;
    }


}