package ugarte.tecsup.com.myapplication10.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ugarte.tecsup.com.myapplication10.R;
import ugarte.tecsup.com.myapplication10.adapters.MyFragmentStatePagerAdapter;
import ugarte.tecsup.com.myapplication10.fragments.EventsFragment;
import ugarte.tecsup.com.myapplication10.fragments.EventsGalleryFragment;

public class EventActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        // Vinculamos el Tablayout con el ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);

        // Añadimos un layout Adapter al ViewPager
        MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EventsFragment(), "EVENTOS");
        adapter.addFragment(new EventsGalleryFragment(), "FECHAS");
        viewPager.setAdapter(adapter);

        // Añadimos íconos y ocultamos el texto al tabLayout
//        tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_menu_call);
//        tabLayout.getTabAt(0).setText("");
//        tabLayout.getTabAt(1).setIcon(android.R.drawable.ic_menu_camera);
//        tabLayout.getTabAt(1).setText("");

    }

}
