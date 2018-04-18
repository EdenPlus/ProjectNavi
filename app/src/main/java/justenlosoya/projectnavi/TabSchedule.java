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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            String daySchedule = prefs.getString("daySchedule", "regular_day");
            int thisSchedule = getId(daySchedule, R.array.class);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
            Date systemDate = Calendar.getInstance().getTime();
            String myDate = sdf.format(systemDate);

            // Period 1
            String p1Class = prefs.getString("p1Class", "c0");

            TextView p1Room = (TextView) inf.findViewById(R.id.p1Room);
            TextView p1Course = (TextView) inf.findViewById(R.id.p1Course);
            TextView p1Teacher = (TextView) inf.findViewById(R.id.p1Teacher);
            TextView p1Time = (TextView) inf.findViewById(R.id.p1Time);

            try {
                int p1ResID = getId(p1Class, R.array.class);

                p1Room.setText(res.getStringArray(p1ResID)[0]);
                p1Course.setText(res.getStringArray(p1ResID)[1]);
                p1Teacher.setText(res.getStringArray(p1ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[0]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[1]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p1Time.setText("Ended at: " + res.getStringArray(thisSchedule)[1] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p1Time.setText("Ends at: " + res.getStringArray(thisSchedule)[1] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p1Time.setText("Starts at: " + res.getStringArray(thisSchedule)[0] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 2
            String p2Class = prefs.getString("p2Class", "c0");

            TextView p2Room = (TextView) inf.findViewById(R.id.p2Room);
            TextView p2Course = (TextView) inf.findViewById(R.id.p2Course);
            TextView p2Teacher = (TextView) inf.findViewById(R.id.p2Teacher);
            TextView p2Time = (TextView) inf.findViewById(R.id.p2Time);

            try {
                int p2ResID = getId(p2Class, R.array.class);

                p2Room.setText(res.getStringArray(p2ResID)[0]);
                p2Course.setText(res.getStringArray(p2ResID)[1]);
                p2Teacher.setText(res.getStringArray(p2ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[2]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[3]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p2Time.setText("Ended at: " + res.getStringArray(thisSchedule)[3] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p2Time.setText("Ends at: " + res.getStringArray(thisSchedule)[3] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p2Time.setText("Starts at: " + res.getStringArray(thisSchedule)[2] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 3
            String p3Class = prefs.getString("p3Class", "c0");

            TextView p3Room = (TextView) inf.findViewById(R.id.p3Room);
            TextView p3Course = (TextView) inf.findViewById(R.id.p3Course);
            TextView p3Teacher = (TextView) inf.findViewById(R.id.p3Teacher);
            TextView p3Time = (TextView) inf.findViewById(R.id.p3Time);

            try {
                int p3ResID = getId(p3Class, R.array.class);

                p3Room.setText(res.getStringArray(p3ResID)[0]);
                p3Course.setText(res.getStringArray(p3ResID)[1]);
                p3Teacher.setText(res.getStringArray(p3ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[4]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[5]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p3Time.setText("Ended at: " + res.getStringArray(thisSchedule)[5] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p3Time.setText("Ends at: " + res.getStringArray(thisSchedule)[5] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p3Time.setText("Starts at: " + res.getStringArray(thisSchedule)[4] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 4
            String p4Class = prefs.getString("p4Class", "c0");

            TextView p4Room = (TextView) inf.findViewById(R.id.p4Room);
            TextView p4Course = (TextView) inf.findViewById(R.id.p4Course);
            TextView p4Teacher = (TextView) inf.findViewById(R.id.p4Teacher);
            TextView p4Time = (TextView) inf.findViewById(R.id.p4Time);

            try {
                int p4ResID = getId(p4Class, R.array.class);

                p4Room.setText(res.getStringArray(p4ResID)[0]);
                p4Course.setText(res.getStringArray(p4ResID)[1]);
                p4Teacher.setText(res.getStringArray(p4ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[6]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[7]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p4Time.setText("Ended at: " + res.getStringArray(thisSchedule)[7] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p4Time.setText("Ends at: " + res.getStringArray(thisSchedule)[7] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p4Time.setText("Starts at: " + res.getStringArray(thisSchedule)[6] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 5
            String p5Class = prefs.getString("p5Class", "c0");

            TextView p5Room = (TextView) inf.findViewById(R.id.p5Room);
            TextView p5Course = (TextView) inf.findViewById(R.id.p5Course);
            TextView p5Teacher = (TextView) inf.findViewById(R.id.p5Teacher);
            TextView p5Time = (TextView) inf.findViewById(R.id.p5Time);

            try {
                int p5ResID = getId(p5Class, R.array.class);

                p5Room.setText(res.getStringArray(p5ResID)[0]);
                p5Course.setText(res.getStringArray(p5ResID)[1]);
                p5Teacher.setText(res.getStringArray(p5ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[8]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[9]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p5Time.setText("Ended at: " + res.getStringArray(thisSchedule)[9] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p5Time.setText("Ends at: " + res.getStringArray(thisSchedule)[9] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p5Time.setText("Starts at: " + res.getStringArray(thisSchedule)[8] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 6
            String p6Class = prefs.getString("p6Class", "c0");

            TextView p6Room = (TextView) inf.findViewById(R.id.p6Room);
            TextView p6Course = (TextView) inf.findViewById(R.id.p6Course);
            TextView p6Teacher = (TextView) inf.findViewById(R.id.p6Teacher);
            TextView p6Time = (TextView) inf.findViewById(R.id.p6Time);

            try {
                int p6ResID = getId(p6Class, R.array.class);

                p6Room.setText(res.getStringArray(p6ResID)[0]);
                p6Course.setText(res.getStringArray(p6ResID)[1]);
                p6Teacher.setText(res.getStringArray(p6ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[10]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[11]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p6Time.setText("Ended at: " + res.getStringArray(thisSchedule)[11] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p6Time.setText("Ends at: " + res.getStringArray(thisSchedule)[11] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p6Time.setText("Starts at: " + res.getStringArray(thisSchedule)[10] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            } catch (Exception e) {
                // SCREAM!!!!
            }

            // Period 7
            String p7Class = prefs.getString("p7Class", "c0");

            TextView p7Room = (TextView) inf.findViewById(R.id.p7Room);
            TextView p7Course = (TextView) inf.findViewById(R.id.p7Course);
            TextView p7Teacher = (TextView) inf.findViewById(R.id.p7Teacher);
            TextView p7Time = (TextView) inf.findViewById(R.id.p7Time);

            try {
                int p7ResID = getId(p7Class, R.array.class);

                p7Room.setText(res.getStringArray(p7ResID)[0]);
                p7Course.setText(res.getStringArray(p7ResID)[1]);
                p7Teacher.setText(res.getStringArray(p7ResID)[2]);

                Date curTime = sdf.parse(myDate);
                Date timeAt = sdf.parse(res.getStringArray(thisSchedule)[12]);
                Date timeEnd = sdf.parse(res.getStringArray(thisSchedule)[13]);
                if (curTime.getTime() >= timeAt.getTime()) {
                    if (curTime.getTime() >= timeEnd.getTime()) {
                        long millse = curTime.getTime() - timeEnd.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p7Time.setText("Ended at: " + res.getStringArray(thisSchedule)[13] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                    else {
                        long millse = timeEnd.getTime() - curTime.getTime();
                        long mills = Math.abs(millse);

                        int Hours = (int) (mills/(1000 * 60 * 60));
                        int Mins = (int) (mills/(1000*60)) % 60;
                        long Secs = (int) (mills / 1000) % 60;

                        p7Time.setText("Ends at: " + res.getStringArray(thisSchedule)[13] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                    }
                }
                else {
                    long millse = timeAt.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    p7Time.setText("Starts at: " + res.getStringArray(thisSchedule)[12] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
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
