package sbin.com.actionbartab.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sbin.com.actionbartab.R;

/**
 * Created by sbin on 10/14/2016.
 */

public class ActivityTab_Fragment extends Fragment {

    private static final String ARG_TAB_SECTION_NUMBER = "section_number";

    public ActivityTab_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Using fragment class not fragment actitvity, needs to override View::createView() function.. instead of onCreate
        // So, declar View vaiable and return it...
        View rootview = inflater.inflate(R.layout.fragment_from_tab, container, false);

        //Call findviewByid from rootview as inner function and case it to textview
        TextView tv  = (TextView) rootview.findViewById(R.id.textview_from_frag_tab);
        tv.setText("Hello from SBIN tab fragment action bar");
        return rootview;

    }
}
