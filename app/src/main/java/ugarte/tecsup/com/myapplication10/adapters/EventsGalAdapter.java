package ugarte.tecsup.com.myapplication10.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.models.EventGal;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventsGalAdapter extends RecyclerView.Adapter<EventsGalAdapter.ViewHolder> {

    private List<EventGal> eventsGal;

    public EventsGalAdapter() {this.eventsGal = new ArrayList<>(); }

    public EventsGalAdapter(List<EventGal> eventsGal) {this.eventsGal = eventsGal;}

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView pictureGal;
        public TextView fullname;
        public TextView fecha;

        public ViewHolder(View itemView){
            super(itemView);
            pictureGal = (ImageView) itemView.findViewById(R.id.pictureGal_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            fecha = (TextView) itemView.findViewById(R.id.fecha_text);
        }
    }

    @Override
    public EventsGalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_eventgallery, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventsGalAdapter.ViewHolder viewHolder, int position) {
        EventGal event = this.eventsGal.get(position);
        viewHolder.fullname.setText(event.getFullname());
        viewHolder.fecha.setText(event.getFecha());

        Context context = viewHolder.itemView.getContext();
        int idRes = context.getResources().getIdentifier(event.getPictureGal(), "drawable", context.getPackageName());
        viewHolder.pictureGal.setImageResource(idRes);
    }

    @Override
    public int getItemCount() {
        return this.eventsGal.size();
    }

}
