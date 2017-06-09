package ugarte.tecsup.com.myapplication10.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.adapters.EventsGalAdapter;
import ugarte.tecsup.com.myapplication10.models.EventGal;
import ugarte.tecsup.com.myapplication10.repositories.EventRepository;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventsGalleryFragment extends Fragment {

    private RecyclerView eventsGalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_events_gallery, container, false);


        eventsGalList = (RecyclerView) view.findViewById(R.id.eventosGallery_list);

        eventsGalList.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<EventGal> eventsGal = EventRepository.getEventsGal();
        eventsGalList.setAdapter(new EventsGalAdapter(eventsGal));

        return view;



    }

}
