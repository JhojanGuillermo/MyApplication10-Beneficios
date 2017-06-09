package ugarte.tecsup.com.myapplication10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.adapters.NoticiasAdapter;
import ugarte.tecsup.com.myapplication10.apiServices.ApiService;
import ugarte.tecsup.com.myapplication10.apiServices.ApiServiceGenerator;
import ugarte.tecsup.com.myapplication10.models.Noticia;

public class NoticiaActivity extends AppCompatActivity {

    private static final String TAG = NoticiaActivity.class.getSimpleName();

    private RecyclerView noticiasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        noticiasList = (RecyclerView) findViewById(R.id.noticias_list);

        noticiasList.setLayoutManager(new LinearLayoutManager(this));

        noticiasList.setAdapter(new NoticiasAdapter(this, new ArrayList<Noticia>()));

        initialize();
    }
    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Noticia>> call = service.listNoticias();

        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Noticia> noticias = response.body();
                        Log.d(TAG, "noticias: " + noticias);

                        NoticiasAdapter adapter = (NoticiasAdapter) noticiasList.getAdapter();
                        adapter.setProductos(noticias);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(NoticiaActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(NoticiaActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}

