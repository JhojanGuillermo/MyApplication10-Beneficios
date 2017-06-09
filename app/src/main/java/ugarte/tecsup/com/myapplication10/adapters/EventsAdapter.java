package ugarte.tecsup.com.myapplication10.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.activities.EventDetalleActivity;
import ugarte.tecsup.com.myapplication10.fragments.EventsFragment;
import ugarte.tecsup.com.myapplication10.models.Event;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private Activity activity;

    private List<Event> events;

    public EventsAdapter(EventsFragment eventsFragment, List<Event> events) {
        this.events = new ArrayList<>();
    }

    public EventsAdapter(Activity activity, List<Event> events) {
        this.events = events;
        this.activity = activity;
    }

    public void setEvents(List<Event> events){
        this.events = events;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView picture;
        public TextView fullname;
        public TextView fecha;
        public TextView lugar;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            fecha = (TextView) itemView.findViewById(R.id.fecha_text);
            lugar = (TextView) itemView.findViewById(R.id.lugar_text);
        }
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder viewHolder, final int position) {
        final Event event = this.events.get(position);
        viewHolder.fullname.setText(event.getTitulo());
        viewHolder.fecha.setText(event.getFecha());
        viewHolder.lugar.setText(event.getLugar());

        Context context = viewHolder.itemView.getContext();
//        int idRes = context.getResources().getIdentifier(event.getImagen(), "drawable", context.getPackageName());
//        viewHolder.picture.setImageResource(idRes);

        Picasso.with(context).load("https://usuarios-api-martincs27.c9users.io/images/eventos/"+ event.getImagen()).into(viewHolder.picture);

        //ver su respectivo detalle
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EventDetalleActivity.class);

                intent.putExtra("ID", event.getId());
//                intent.putExtra("TituloEvent", event.getTitulo())
//                        .putExtra("FechaEvent", event.getFecha())
//                        .putExtra("LugarEvent", event.getLugar())
//                        .putExtra("DescEvent", event.getDescripcion());
                activity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.events.size();
    }

}
