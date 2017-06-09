package ugarte.tecsup.com.myapplication10.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ugarte.tecsup.com.myapplication10.R;

public class MainActivity extends AppCompatActivity {

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
}