package justenlosoya.projectnavi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
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
            
        } catch (NullPointerException e) {
            // Ugh
        }
        // End layout Preference Changes
        return inf;
    }

}
