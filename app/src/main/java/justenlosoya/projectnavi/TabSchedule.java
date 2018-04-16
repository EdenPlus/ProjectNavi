package justenlosoya.projectnavi;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Field;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by justenlosoya on 10/20/17.
 */

public class TabSchedule extends Fragment {
    View inf;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inf = inflater.inflate(R.layout.tab_schedule, container, false);
        // Start Layout Preference Changes
        try {
            Resources res = getResources();
            SharedPreferences prefs = getDefaultSharedPreferences(this.getActivity().getApplicationContext());

            // Period 1
            String p1Class = prefs.getString("p1Class", "c0");

            TextView p1Room = (TextView) inf.findViewById(R.id.p1Room);
            TextView p1Course = (TextView) inf.findViewById(R.id.p1Course);
            TextView p1Teacher = (TextView) inf.findViewById(R.id.p1Teacher);
            TextView p1TimeTill = (TextView) inf.findViewById(R.id.p1TimeTill);
            TextView p1TimeAt = (TextView) inf.findViewById(R.id.p1TimeAt);

            try {
                int p1ResID = getId(p1Class, R.array.class);

                p1Room.setText(res.getStringArray(p1ResID)[0]);
                p1Course.setText(res.getStringArray(p1ResID)[1]);
                p1Teacher.setText(res.getStringArray(p1ResID)[2]);
                p1TimeTill.setText("0:00");
                p1TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 2
            String p2Class = prefs.getString("p2Class", "c0");

            TextView p2Room = (TextView) inf.findViewById(R.id.p2Room);
            TextView p2Course = (TextView) inf.findViewById(R.id.p2Course);
            TextView p2Teacher = (TextView) inf.findViewById(R.id.p2Teacher);
            TextView p2TimeTill = (TextView) inf.findViewById(R.id.p2TimeTill);
            TextView p2TimeAt = (TextView) inf.findViewById(R.id.p2TimeAt);

            try {
                int p2ResID = getId(p2Class, R.array.class);

                p2Room.setText(res.getStringArray(p2ResID)[0]);
                p2Course.setText(res.getStringArray(p2ResID)[1]);
                p2Teacher.setText(res.getStringArray(p2ResID)[2]);
                p2TimeTill.setText("0:00");
                p2TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 3
            String p3Class = prefs.getString("p3Class", "c0");

            TextView p3Room = (TextView) inf.findViewById(R.id.p3Room);
            TextView p3Course = (TextView) inf.findViewById(R.id.p3Course);
            TextView p3Teacher = (TextView) inf.findViewById(R.id.p3Teacher);
            TextView p3TimeTill = (TextView) inf.findViewById(R.id.p3TimeTill);
            TextView p3TimeAt = (TextView) inf.findViewById(R.id.p3TimeAt);

            try {
                int p3ResID = getId(p3Class, R.array.class);

                p3Room.setText(res.getStringArray(p3ResID)[0]);
                p3Course.setText(res.getStringArray(p3ResID)[1]);
                p3Teacher.setText(res.getStringArray(p3ResID)[2]);
                p3TimeTill.setText("0:00");
                p3TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 4
            String p4Class = prefs.getString("p4Class", "c0");

            TextView p4Room = (TextView) inf.findViewById(R.id.p4Room);
            TextView p4Course = (TextView) inf.findViewById(R.id.p4Course);
            TextView p4Teacher = (TextView) inf.findViewById(R.id.p4Teacher);
            TextView p4TimeTill = (TextView) inf.findViewById(R.id.p4TimeTill);
            TextView p4TimeAt = (TextView) inf.findViewById(R.id.p4TimeAt);

            try {
                int p4ResID = getId(p4Class, R.array.class);

                p4Room.setText(res.getStringArray(p4ResID)[0]);
                p4Course.setText(res.getStringArray(p4ResID)[1]);
                p4Teacher.setText(res.getStringArray(p4ResID)[2]);
                p4TimeTill.setText("0:00");
                p4TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 5
            String p5Class = prefs.getString("p5Class", "c0");

            TextView p5Room = (TextView) inf.findViewById(R.id.p5Room);
            TextView p5Course = (TextView) inf.findViewById(R.id.p5Course);
            TextView p5Teacher = (TextView) inf.findViewById(R.id.p5Teacher);
            TextView p5TimeTill = (TextView) inf.findViewById(R.id.p5TimeTill);
            TextView p5TimeAt = (TextView) inf.findViewById(R.id.p5TimeAt);

            try {
                int p5ResID = getId(p5Class, R.array.class);

                p5Room.setText(res.getStringArray(p5ResID)[0]);
                p5Course.setText(res.getStringArray(p5ResID)[1]);
                p5Teacher.setText(res.getStringArray(p5ResID)[2]);
                p5TimeTill.setText("0:00");
                p5TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 6
            String p6Class = prefs.getString("p6Class", "c0");

            TextView p6Room = (TextView) inf.findViewById(R.id.p6Room);
            TextView p6Course = (TextView) inf.findViewById(R.id.p6Course);
            TextView p6Teacher = (TextView) inf.findViewById(R.id.p6Teacher);
            TextView p6TimeTill = (TextView) inf.findViewById(R.id.p6TimeTill);
            TextView p6TimeAt = (TextView) inf.findViewById(R.id.p6TimeAt);

            try {
                int p6ResID = getId(p6Class, R.array.class);

                p6Room.setText(res.getStringArray(p6ResID)[0]);
                p6Course.setText(res.getStringArray(p6ResID)[1]);
                p6Teacher.setText(res.getStringArray(p6ResID)[2]);
                p6TimeTill.setText("0:00");
                p6TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 7
            String p7Class = prefs.getString("p7Class", "c0");

            TextView p7Room = (TextView) inf.findViewById(R.id.p7Room);
            TextView p7Course = (TextView) inf.findViewById(R.id.p7Course);
            TextView p7Teacher = (TextView) inf.findViewById(R.id.p7Teacher);
            TextView p7TimeTill = (TextView) inf.findViewById(R.id.p7TimeTill);
            TextView p7TimeAt = (TextView) inf.findViewById(R.id.p7TimeAt);

            try {
                int p7ResID = getId(p7Class, R.array.class);

                p7Room.setText(res.getStringArray(p7ResID)[0]);
                p7Course.setText(res.getStringArray(p7ResID)[1]);
                p7Teacher.setText(res.getStringArray(p7ResID)[2]);
                p7TimeTill.setText("0:00");
                p7TimeAt.setText("0:00");
            } catch (Exception e) {
                // SCREAM!!!!
            }

        } catch (NullPointerException e) {
            // Ugh
        }
        // End layout Preference Changes
        return inf;
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }
}
