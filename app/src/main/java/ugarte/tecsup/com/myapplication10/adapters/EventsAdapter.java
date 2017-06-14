package ugarte.tecsup.com.myapplication10.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.activities.EventDetalleActivity;
import ugarte.tecsup.com.myapplication10.activities.LoginActivity;
import ugarte.tecsup.com.myapplication10.activities.MainActivity;
import ugarte.tecsup.com.myapplication10.apiServices.ApiService;
import ugarte.tecsup.com.myapplication10.apiServices.ApiServiceGenerator;
import ugarte.tecsup.com.myapplication10.fragments.EventsFragment;
import ugarte.tecsup.com.myapplication10.models.Event;
import ugarte.tecsup.com.myapplication10.models.ResponseMessage;
import ugarte.tecsup.com.myapplication10.models.Usuario;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private static final String TAG = EventsAdapter.class.getSimpleName();
    private SharedPreferences sharedPreferences;

    private Activity activity;

    private List<Event> events;
    private Usuario users;

    public EventsAdapter(EventsFragment eventsFragment, List<Event> events) {
        this.events = new ArrayList<>();
    }

    public EventsAdapter(Activity activity, List<Event> events) {
        sharedPreferences = activity.getSharedPreferences(LoginActivity.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
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
        public CheckBox participar;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            fecha = (TextView) itemView.findViewById(R.id.fecha_text);
            lugar = (TextView) itemView.findViewById(R.id.lugar_text);
            participar = (CheckBox) itemView.findViewById(R.id.participar);
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

        viewHolder.participar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox checkbox = (CheckBox)v;

                if(checkbox.isChecked()){
                    Log.d(TAG, "CHECKED!!");
                    Toast.makeText(EventsAdapter.this.activity, "Asistencia confirmada", Toast.LENGTH_SHORT).show();
                    ApiService service = ApiServiceGenerator.createService(ApiService.class);
                    service.asistencias(sharedPreferences.getString("username", null), event.getId()).enqueue(new Callback<ResponseMessage>() {
                        @Override
                        public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                            try {

                                int statusCode = response.code();
                                Log.d(TAG, "HTTP status code: " + statusCode);

                                if (response.isSuccessful()) {
                                    ResponseMessage responseMessage = response.body();
                                    Log.d(TAG, "responseMessage: " + responseMessage);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    boolean success = editor
                                            .commit();
                                } else {
                                    Log.e(TAG, "onError: " + response.errorBody().string());
                                    throw new Exception("Usuario y/o password incorrectos");
                                }

                            } catch (Throwable t) {
                                try {
                                    Log.e(TAG, "onThrowable: " + t.toString(), t);
                                    Toast.makeText(EventsAdapter.this.activity, t.getMessage(), Toast.LENGTH_LONG).show();
                                } catch (Throwable x) {
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseMessage> call, Throwable t) {
                            Log.e(TAG, "onFailure: " + t.toString());
                            Toast.makeText(EventsAdapter.this.activity, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });


                }else{
                    Log.d(TAG, "NO CHECKED!!");
                    Toast.makeText(EventsAdapter.this.activity, "Asistencia cancelada", Toast.LENGTH_SHORT).show();
                    ApiService service = ApiServiceGenerator.createService(ApiService.class);
                    service.inasistencias(sharedPreferences.getString("username", null), event.getId()).enqueue(new Callback<ResponseMessage>() {
                        @Override
                        public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                            try {

                                int statusCode = response.code();
                                Log.d(TAG, "HTTP status code: " + statusCode);

                                if (response.isSuccessful()) {
                                    ResponseMessage responseMessage = response.body();
                                    Log.d(TAG, "responseMessage: " + responseMessage);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    boolean success = editor
                                            .commit();
                                } else {
                                    Log.e(TAG, "onError: " + response.errorBody().string());
                                    throw new Exception("Usuario y/o password incorrectos");
                                }

                            } catch (Throwable t) {
                                try {
                                    Log.e(TAG, "onThrowable: " + t.toString(), t);
                                    Toast.makeText(EventsAdapter.this.activity, t.getMessage(), Toast.LENGTH_LONG).show();
                                } catch (Throwable x) {
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseMessage> call, Throwable t) {
                            Log.e(TAG, "onFailure: " + t.toString());
                            Toast.makeText(EventsAdapter.this.activity, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

}
