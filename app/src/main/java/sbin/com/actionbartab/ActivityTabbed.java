package sbin.com.actionbartab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
    //private PagerAdapter pagerAdapter;
    private sectionPagerAdatper sectionPA;

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

        //To navigate to go back....also modify menifest xml as well and this will be caught from onOptionItemselected call back function
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initiate sectionPagerAdatper which extends FragmentPagerAdapter -- PagerAdapter is replaced by this
        sectionPA = new sectionPagerAdatper(getSupportFragmentManager());

        // Set ViewPager into android.support.v4.view.ViewPager@id container_tabbed
        // As per android development guide, viewpager need PagerAdapter
        viewPager = (ViewPager) findViewById(R.id.container_tabbed);
        viewPager.setAdapter(sectionPA);

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
            // this is for catching setDisplayHomeAsUpEnabled
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
            default:
                break;

        }
        return true;
    }

    public static class PlaceHolderActTab extends Fragment {

        private static final String ARG_TAB_SECTION_NUMBER = "section_number";

        public PlaceHolderActTab() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //Using fragment class not fragment actitvity, needs to override View::createView() function.. instead of onCreate
            // So, declar View vaiable and return it...
            View rootview = inflater.inflate(R.layout.fragment_from_tab, container, false);
            displayTabtext(rootview);
            return rootview;

        }

        public void displayTabtext(View rootview) {
            //Call findviewByid from rootview as inner function and case it to textview
            TextView tv = (TextView) rootview.findViewById(R.id.textview_from_frag_tab);

            int tabId = getArguments().getInt(ARG_TAB_SECTION_NUMBER);
            switch (tabId){
                case 0:
                    tv.setText("Boring.. what the.. 1st");
                    return;
                case 1:
                    tv.setText("Need feed ..where am I .. 2nd");
                    return;
                case 2:
                    tv.setText("Want to work.. really 3rd");
                    return;
                default:
                    return;
            }


            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        }

        // populating newInstance method instead of calling this class from activitytabbed.
        public static PlaceHolderActTab newInstance(int setctionNumber) {

            Bundle args = new Bundle();
            PlaceHolderActTab fragment = new PlaceHolderActTab();
            args.putInt(ARG_TAB_SECTION_NUMBER, setctionNumber);
            fragment.setArguments(args);
            return fragment;
        }
    }
    public class sectionPagerAdatper extends FragmentPagerAdapter {

        public sectionPagerAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag =  PlaceHolderActTab.newInstance(position);
            return frag;
        }

        @Override
        public int getCount() {
            //shows hardcoded 3 pages
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Sbin 1";
                case 1:
                    return "Sbin 2";
                case 2:
                    return "Sbin 3";
                default:
                    break;
            }
            return super.getPageTitle(position);
        }
    }
}