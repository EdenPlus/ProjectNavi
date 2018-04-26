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
            int schedule = getId(prefs.getString("daySchedule", "regular_day"), R.array.class);

            // Period 1
            String p1Class = prefs.getString("p1Class", "c0");
            int p1ResID = getId(p1Class, R.array.class);
            TextView p1Room = (TextView) inf.findViewById(R.id.p1Room);
            TextView p1Course = (TextView) inf.findViewById(R.id.p1Course);
            TextView p1Teacher = (TextView) inf.findViewById(R.id.p1Teacher);
            TextView p1Time = (TextView) inf.findViewById(R.id.p1Time);

            fillPeriod(res, schedule, p1ResID, p1Room, p1Course, p1Teacher, p1Time, 0, 1);


            // Period 2
            String p2Class = prefs.getString("p2Class", "c0");
            int p2ResID = getId(p2Class, R.array.class);
            TextView p2Room = (TextView) inf.findViewById(R.id.p2Room);
            TextView p2Course = (TextView) inf.findViewById(R.id.p2Course);
            TextView p2Teacher = (TextView) inf.findViewById(R.id.p2Teacher);
            TextView p2Time = (TextView) inf.findViewById(R.id.p2Time);

            fillPeriod(res, schedule, p2ResID, p2Room, p2Course, p2Teacher, p2Time, 2, 3);


            // Period 3
            String p3Class = prefs.getString("p3Class", "c0");
            int p3ResID = getId(p3Class, R.array.class);
            TextView p3Room = (TextView) inf.findViewById(R.id.p3Room);
            TextView p3Course = (TextView) inf.findViewById(R.id.p3Course);
            TextView p3Teacher = (TextView) inf.findViewById(R.id.p3Teacher);
            TextView p3Time = (TextView) inf.findViewById(R.id.p3Time);

            fillPeriod(res, schedule, p3ResID, p3Room, p3Course, p3Teacher, p3Time, 4, 5);


            // Period 4
            String p4Class = prefs.getString("p4Class", "c0");
            int p4ResID = getId(p4Class, R.array.class);
            TextView p4Room = (TextView) inf.findViewById(R.id.p4Room);
            TextView p4Course = (TextView) inf.findViewById(R.id.p4Course);
            TextView p4Teacher = (TextView) inf.findViewById(R.id.p4Teacher);
            TextView p4Time = (TextView) inf.findViewById(R.id.p4Time);

            fillPeriod(res, schedule, p4ResID, p4Room, p4Course, p4Teacher, p4Time, 6, 7);


            // Period 5
            String p5Class = prefs.getString("p5Class", "c0");
            int p5ResID = getId(p5Class, R.array.class);
            TextView p5Room = (TextView) inf.findViewById(R.id.p5Room);
            TextView p5Course = (TextView) inf.findViewById(R.id.p5Course);
            TextView p5Teacher = (TextView) inf.findViewById(R.id.p5Teacher);
            TextView p5Time = (TextView) inf.findViewById(R.id.p5Time);

            fillPeriod(res, schedule, p5ResID, p5Room, p5Course, p5Teacher, p5Time, 8, 9);


            // Period 6
            String p6Class = prefs.getString("p6Class", "c0");
            int p6ResID = getId(p6Class, R.array.class);
            TextView p6Room = (TextView) inf.findViewById(R.id.p6Room);
            TextView p6Course = (TextView) inf.findViewById(R.id.p6Course);
            TextView p6Teacher = (TextView) inf.findViewById(R.id.p6Teacher);
            TextView p6Time = (TextView) inf.findViewById(R.id.p6Time);

            fillPeriod(res, schedule, p6ResID, p6Room, p6Course, p6Teacher, p6Time, 10, 11);


            // Period 7
            String p7Class = prefs.getString("p7Class", "c0");
            int p7ResID = getId(p7Class, R.array.class);
            TextView p7Room = (TextView) inf.findViewById(R.id.p7Room);
            TextView p7Course = (TextView) inf.findViewById(R.id.p7Course);
            TextView p7Teacher = (TextView) inf.findViewById(R.id.p7Teacher);
            TextView p7Time = (TextView) inf.findViewById(R.id.p7Time);

            fillPeriod(res, schedule, p7ResID, p7Room, p7Course, p7Teacher, p7Time, 12, 13);
        } catch (Exception e) {
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

    public static void fillPeriod(Resources res, int schedule, int resID, TextView tRoom, TextView tCourse, TextView tTeacher, TextView tTime, int start, int end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
            Date systemDate = Calendar.getInstance().getTime();
            String myDate = sdf.format(systemDate);

            tRoom.setText("Room: " + res.getStringArray(resID)[0]);
            tCourse.setText(/*"Course: " + */res.getStringArray(resID)[1]);
            tTeacher.setText(/*"Teacher: " + */res.getStringArray(resID)[2]);

            Date curTime = sdf.parse(myDate);
            Date timeAt = sdf.parse(res.getStringArray(schedule)[start]);
            Date timeEnd = sdf.parse(res.getStringArray(schedule)[end]);
            if (curTime.getTime() >= timeAt.getTime()) {
                if (curTime.getTime() >= timeEnd.getTime()) {
                    long millse = curTime.getTime() - timeEnd.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    tTime.setText("Ended at: " + res.getStringArray(schedule)[end] + " (-" + Hours + ":" + Mins + ":" + Secs + ")");
                }
                else {
                    long millse = timeEnd.getTime() - curTime.getTime();
                    long mills = Math.abs(millse);

                    int Hours = (int) (mills/(1000 * 60 * 60));
                    int Mins = (int) (mills/(1000*60)) % 60;
                    long Secs = (int) (mills / 1000) % 60;

                    tTime.setText("Ends at: " + res.getStringArray(schedule)[end] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
                }
            }
            else {
                long millse = timeAt.getTime() - curTime.getTime();
                long mills = Math.abs(millse);

                int Hours = (int) (mills/(1000 * 60 * 60));
                int Mins = (int) (mills/(1000*60)) % 60;
                long Secs = (int) (mills / 1000) % 60;

                tTime.setText("Starts at: " + res.getStringArray(schedule)[start] + " (" + Hours + ":" + Mins + ":" + Secs + ")");
            }
        } catch (Exception e) {
            // SCREAM!!!!
        }
    }
}
