package justenlosoya.projectnavi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
            TextView p1Teacher = (TextView) inf.findViewById(R.id.p1Teacher);
            TextView p1Room = (TextView) inf.findViewById(R.id.p1Room);
            TextView p1Course = (TextView) inf.findViewById(R.id.p1Course);
            TextView p1TimeTill = (TextView) inf.findViewById(R.id.p1TimeTill);
            TextView p1TimeAt = (TextView) inf.findViewById(R.id.p1TimeAt);

            /*
            TouchImageView mapView = (TouchImageView) inf.findViewById(R.id.mapImg);
            SharedPreferences prefs = getDefaultSharedPreferences(this.getActivity().getApplicationContext());
            String image = prefs.getString("mapImage", "b_map");
            if (image.equals("b_map")) {
                mapView.setImageResource(R.drawable.b_map);
            }
            else {
                mapView.setImageResource(R.drawable.s_map);
            }
            */
        } catch (NullPointerException e) {
            // Ugh
        }
        // End layout Preference Changes
        return inf;
    }
}
