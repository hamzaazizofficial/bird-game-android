package hamza.app.birdgame.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hamza.app.birdgame.R;

public class ViewPagerManager extends AppCompatActivity {

    sectionPagerAdapter msectionPagerAdapter;
    ViewPager viewPager;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_manager);

        viewPager = findViewById(R.id.container);
        msectionPagerAdapter = new sectionPagerAdapter(getSupportFragmentManager());

        setupViewPager(viewPager);
        setViewPager(0);
    }

    private void setupViewPager(ViewPager viewPager) {
        sectionPagerAdapter adapter = new sectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SelectBird1(),"Fragment 1");

        //setting adapter
        viewPager.setAdapter(adapter);
    }

    //fn for navigating fragments
    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }
}
