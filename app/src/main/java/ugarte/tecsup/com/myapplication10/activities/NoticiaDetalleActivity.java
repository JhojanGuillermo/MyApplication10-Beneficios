package ugarte.tecsup.com.myapplication10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.apiServices.ApiService;
import ugarte.tecsup.com.myapplication10.apiServices.ApiServiceGenerator;
import ugarte.tecsup.com.myapplication10.models.Noticia;

public class NoticiaDetalleActivity extends AppCompatActivity {

    private static final String TAG = NoticiaDetalleActivity.class.getSimpleName();

    private int id;

    private String titulo;

    private String fecha;

    private String hora;

    private String detalles;

    private int picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_detalle);

        if (this.getIntent().getExtras() != null){
            Bundle bundle = this.getIntent().getExtras();
            id = bundle.getInt("ID");
//            titulo = bundle.getString("TITULO");
//            fecha = bundle.getString("FECHA");
//            hora = bundle.getString("HORA");
//            detalles = bundle.getString("DETALLES");
//            picture = bundle.getInt("PICTURE");
        }

        //llamara al servicio por ID o buscar en tu lista el objeto por ese ID

        //TextView textView = (TextView) findViewById(R.id.textview);
        //textView.setText("Noticia " + id);
//        TextView tit = (TextView) findViewById(R.id.text_titulo);
//        tit.setText(titulo);
//        TextView fech = (TextView) findViewById(R.id.text_fecha);
//        fech.setText(fecha);
//        TextView hor = (TextView) findViewById(R.id.text_hora);
//        hor.setText(hora);
//        TextView det = (TextView) findViewById(R.id.text_descripcion);
//        det.setText(detalles);
//        ImageView img = (ImageView) findViewById(R.id.portada);
//        img.setImageResource(picture);

        initialize();

    }
    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<Noticia> call = service.getNoticias(id);

        call.enqueue(new Callback<Noticia>() {
            @Override
            public void onResponse(Call<Noticia> call, Response<Noticia> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        Noticia noticia = response.body();
                        Log.d(TAG, "noticias: " + noticia);

                        //Noticia noticia = NoticiaRepository.getNoticias(id);

                        TextView tit = (TextView) findViewById(R.id.text_titulo);
                        tit.setText(noticia.getTitulo());
                        ImageView img = (ImageView) findViewById(R.id.portada);
                        Picasso.with(NoticiaDetalleActivity.this).load("https://usuarios-api-martincs27.c9users.io/images/noticias/"+ noticia.getImagen()).into(img);
                        TextView fech = (TextView) findViewById(R.id.text_fecha);
                        fech.setText(noticia.getFecha());
                        TextView det = (TextView) findViewById(R.id.text_descripcion);
                        det.setText(noticia.getDesc2());

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(NoticiaDetalleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<Noticia> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(NoticiaDetalleActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}

