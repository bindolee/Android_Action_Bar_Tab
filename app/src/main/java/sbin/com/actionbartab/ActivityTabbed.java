package sbin.com.actionbartab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        //you can re-use the activity_main xml layout ... if you want.

        // Set toolbar to support activity_tabbed.xml -
        // this supports android.support.design.widget.AppBarLayout and android.support.v7.widget.Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tabbed);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Action Bar Tab");
        getSupportActionBar().setSubtitle("sbin");
        getSupportActionBar().setLogo(R.drawable.pluralsight_logo_whiteback);

        // Set ViewPager into android.support.v4.view.ViewPager@id container_tabbed
        // As per android development guide, viewpager need PagerAdapter
        viewPager = (ViewPager) findViewById(R.id.container_tabbed);
        viewPager.setAdapter(pagerAdapter);

        //Set up TabLayout to android.support.design.widget.TabLayout with @id tabs_tabbed
        //TabLayout needs to be viewered with android.support.v4.view.ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_tabbed);
        tabLayout.setupWithViewPager(viewPager);

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