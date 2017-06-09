package ugarte.tecsup.com.myapplication10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity {


    ImageButton siguente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        siguente = (ImageButton) findViewById(R.id.imageButton2);
        siguente.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v) {
                Intent siguente = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(siguente);
            }

        });

    }
}