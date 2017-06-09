package ugarte.tecsup.com.myapplication10.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.adapters.ImageAdapter;
import uk.co.senab.photoview.PhotoViewAttacher;

public class FullImageActivity extends AppCompatActivity {

    ImageView imageView;

    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        imageView = (ImageView) findViewById(R.id.imageView);

        mAttacher = new PhotoViewAttacher(imageView);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(adapter.images[position]);
    }
}
