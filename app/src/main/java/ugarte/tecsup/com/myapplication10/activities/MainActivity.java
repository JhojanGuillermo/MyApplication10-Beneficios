package ugarte.tecsup.com.myapplication10.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import ugarte.tecsup.com.myapplication10.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    public static final String SHARED_PREFERENCE_NAME = "MyApp";

    ImageButton noticias;
    ImageButton eventos;
    ImageButton beneficios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beneficios = (ImageButton) findViewById(R.id.imageButton2);
        beneficios.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v) {
                Intent beneficio = new Intent(MainActivity.this, BeneficioActivity.class);
                startActivity(beneficio);
            }
        });

        noticias = (ImageButton) findViewById(R.id.imageButton3);
        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noticia = new Intent(MainActivity.this, NoticiaActivity.class);
                startActivity(noticia);
            }
        });

        eventos = (ImageButton) findViewById(R.id.imageButton1);
        eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evento = new Intent(MainActivity.this, EventActivity.class);
                startActivity(evento);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_logout:
                callLogout(null);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void callLogout(View view){
        Log.d(TAG, "Loged");
            SharedPreferences settings = getSharedPreferences(SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.remove("islogged");
            editor.commit();
            finish();
    }
}