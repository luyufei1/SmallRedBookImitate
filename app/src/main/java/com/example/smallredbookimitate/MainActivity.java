package com.example.smallredbookimitate;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.smallredbookimitate.Adapter.ViewPagerAdapter;
import com.example.smallredbookimitate.Fragment_nav.HomePageFragment;
import com.example.smallredbookimitate.Fragment_nav.MessageFragment;
import com.example.smallredbookimitate.Fragment_nav.MoreFragment;
import com.example.smallredbookimitate.Fragment_nav.MyFragment;
import com.example.smallredbookimitate.Fragment_nav.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private CustomViewpager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //主界面的viewpager配置
        navigationView = findViewById(R.id.nav_bottom);
        viewPager = (CustomViewpager) findViewById(R.id.viewpager);
        viewPager.setSlidingEnable(false);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomePageFragment());
        fragments.add((new VideoFragment()));
        fragments.add(new MoreFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MyFragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(viewPagerAdapter);

        //底部导航栏监听事件
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_home_page) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.item_video) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.item_more) {
                    Log.e("TAG", "onNavigationItemSelected: " + "AAAAA");
                    viewPager.setCurrentItem(2);
                    return true;
                } else if (item.getItemId() == R.id.item_message) {
                    viewPager.setCurrentItem(3);
                    return true;
                } else if (item.getItemId() == R.id.item_my) {
                    viewPager.setCurrentItem(4);
                    return true;
                }
                return false;
            }
        });

    }

}

