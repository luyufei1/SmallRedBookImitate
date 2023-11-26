package com.example.smallredbookimitate.Fragment_nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.smallredbookimitate.Adapter.TabAdapter;
import com.example.smallredbookimitate.Fragment_toolbar.FindFragment;
import com.example.smallredbookimitate.Fragment_toolbar.FollowedFragment;
import com.example.smallredbookimitate.Fragment_toolbar.LocalFragment;
import com.example.smallredbookimitate.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private TabAdapter tabAdapter;
    private List<Fragment> fragments;
    private List<String> tabs;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        //主界面的viewpager配置
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager_A);


        fragments = new ArrayList<>();
        fragments.add(new FollowedFragment());
        fragments.add(new FindFragment());
        fragments.add(new LocalFragment());

        tabs = new ArrayList<>();
        tabs.add("关注");
        tabs.add("发现");
        tabs.add("西安");
        MyAdapter adapter = new MyAdapter(requireActivity(), fragments);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabs.get(position))).attach();
        return view;
    }
}

class MyAdapter extends FragmentStateAdapter {

    List<Fragment> fragments;


    public MyAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}