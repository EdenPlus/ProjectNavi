package justenlosoya.projectnavi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by justenlosoya on 10/20/17.
 */

public class TabMap extends Fragment {
    // Solved as per: https://stackoverflow.com/questions/16539029/change-textview-inside-fragment
    View inf;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inf = inflater.inflate(R.layout.tab_map, container, false);
        // Start Layout Preference Changes
        try {
            TouchImageView mapView = (TouchImageView) inf.findViewById(R.id.mapImg);
            SharedPreferences prefs = getDefaultSharedPreferences(this.getActivity().getApplicationContext());
            String image = prefs.getString("mapImage", "b_map");
            if (image.equals("b_map")) {
                mapView.setImageResource(R.drawable.b_map);
            }
            else {
                mapView.setImageResource(R.drawable.s_map);
            }
        } catch (NullPointerException e) {
            // Ugh
        }
        // End layout Preference Changes
        return inf;
    }

}