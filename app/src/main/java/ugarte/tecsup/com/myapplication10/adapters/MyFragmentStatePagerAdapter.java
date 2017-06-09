package ugarte.tecsup.com.myapplication10.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JShanksX13 on 9/06/2017.
 */

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter{
    private final List<String> titles = new ArrayList<>();
    private final List<Fragment> fragments = new ArrayList<>();

    public MyFragmentStatePagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }

}
