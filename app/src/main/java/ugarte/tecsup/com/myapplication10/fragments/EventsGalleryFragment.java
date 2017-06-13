package ugarte.tecsup.com.myapplication10.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ugarte.tecsup.com.myapplication10.R;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventsGalleryFragment extends Fragment {

//    CalendarView calendar;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_events_gallery, container, false);
//
//        calendar = (CalendarView) view.findViewById(R.id.calendar_events);
//
//        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//
//                Toast.makeText(getActivity().getBaseContext(), "Selected date" +dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
//            }
//        });
//        return view;
//    }

    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_gallery, container, false);

        final CompactCalendarView compactCalendar = (CompactCalendarView) view.findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        compactCalendar.setFirstDayOfWeek(Calendar.SUNDAY);

        Event ev1 = new Event(Color.GREEN, 1497621600000L, "Teacher's Professional Day");
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getActivity().getApplicationContext();

                if (dateClicked.toString().compareTo("Fri Jun 16 09:00:00 AST 2017") == 0){
                    Toast.makeText(context, "Teacher's Professional Day", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });
        return view;
    }
}
