package ugarte.tecsup.com.myapplication10.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import ugarte.tecsup.com.myapplication10.R;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventsGalleryFragment extends Fragment {

    CalendarView calendar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_gallery, container, false);

        calendar = (CalendarView) view.findViewById(R.id.calendar_events);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                Toast.makeText(getActivity().getBaseContext(), "Selected date" +dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
