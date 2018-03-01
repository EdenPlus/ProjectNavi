package justenlosoya.projectnavi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by justenlosoya on 10/20/17.
 */

public class TabCalendar extends Fragment {
    View inf;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inf = inflater.inflate(R.layout.tab_calendar, container, false);
        // Start Layout Preference Changes
        try {
            TextView t = (TextView) inf.findViewById(R.id.textViewC);
            Random r = new Random();
            int i1 = r.nextInt(100);
            t.setText("Randomly generated number when the fragment is loaded: " + i1);
        } catch (NullPointerException e) {
            // Ugh
        }
        // End layout Preference Changes
        return inf;
    }

}
