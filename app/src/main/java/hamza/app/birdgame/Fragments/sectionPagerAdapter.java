package hamza.app.birdgame.Fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class sectionPagerAdapter extends FragmentPagerAdapter {

    public List<Fragment> fragmentList = new ArrayList<>();
    public List<String> fragmentTitleList = new ArrayList<>();

    public sectionPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
}

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
