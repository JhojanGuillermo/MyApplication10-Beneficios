package ugarte.tecsup.com.myapplication10.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ugarte.tecsup.com.myapplication10.apiServices.ApiService;
import ugarte.tecsup.com.myapplication10.apiServices.ApiServiceGenerator;
import ugarte.tecsup.com.myapplication10.models.Beneficio;
import ugarte.tecsup.com.myapplication10.adapters.BeneficioAdapter;
import ugarte.tecsup.com.myapplication10.R;

public class BeneficioActivity extends AppCompatActivity {

    private static final String TAG =  BeneficioActivity.class.getSimpleName();

    private RecyclerView beneficiosList;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficio);

          beneficiosList = (RecyclerView) findViewById(R.id.beneficios_list);

          beneficiosList.setLayoutManager(new LinearLayoutManager(this));

          beneficiosList.setAdapter(new BeneficioAdapter());

          initialize();
    }

    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<Beneficio>> call = service.listBeneficios();

        call.enqueue(new Callback<List<Beneficio>>() {
            @Override
            public void onResponse(Call<List<Beneficio>> call, Response<List<Beneficio>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Beneficio> beneficios = response.body();
                        Log.d(TAG, "beneficios: " + beneficios);

                        BeneficioAdapter adapter = (BeneficioAdapter) beneficiosList.getAdapter();
                        adapter.setBeneficios(beneficios);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(BeneficioActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Beneficio>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(BeneficioActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}
