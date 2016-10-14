package sbin.com.actionbartab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: Jim
 * Date: 6/19/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ActivityTabbedPartial extends Activity {
    private static final String LOG_TAG = "ActivityTabbedPartial";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_part_selectable_part_fixed);
        Log.i(LOG_TAG,"Activity Tabbed Partial page is showing");
    }

}