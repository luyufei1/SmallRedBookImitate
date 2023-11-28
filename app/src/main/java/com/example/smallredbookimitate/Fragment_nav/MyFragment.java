package com.example.smallredbookimitate.Fragment_nav;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.smallredbookimitate.Fragment_toolbar.FindFragment;
import com.example.smallredbookimitate.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class MyFragment extends Fragment {

    private NestCollapsingToolbarLayout toolbarLayout;
    private RelativeLayout rlTitle;
    private LinearLayout llSmallAuthor;

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private List<Fragment> fragments;
    private List<String> tabs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        toolbarLayout = (NestCollapsingToolbarLayout) view.findViewById(R.id.toolbarLayout);
        rlTitle = (RelativeLayout) view.findViewById(R.id.rlTitle);
        llSmallAuthor = (LinearLayout) view.findViewById(R.id.llSmallAuthor);
        tabLayout =(TabLayout) view.findViewById(R.id.my_tablayout);
        viewPager = (ViewPager2) view.findViewById(R.id.my_viewpager);
        //实现滚动效果
        //设置一个监听器，当scrim的显示状态发生变化时，这个监听器将收到通知
        toolbarLayout.setOnScrimsShowListener(new NestCollapsingToolbarLayout.OnScrimsShowListener() {
            @Override
            public void onScrimsShowChange(NestCollapsingToolbarLayout nestCollapsingToolbarLayout, boolean isScrimesShow) {
                if (isScrimesShow) {
                    int purple = Color.parseColor("#8E7FA8");
                    rlTitle.setBackgroundColor(purple);
                    llSmallAuthor.setVisibility(View.VISIBLE);
                } else {
                    rlTitle.setBackgroundColor(Color.TRANSPARENT);

                   /* if (objectAnimator.isRunning()) {
                        objectAnimator.cancel();
                    }*/
                    llSmallAuthor.setVisibility(View.INVISIBLE);
                }
            }
        });

        //实现tab和viewpager关联
        fragments = new ArrayList<>();
        fragments.add(new FindFragment());
        fragments.add(new FindFragment());
        fragments.add(new FindFragment());

        tabs = new ArrayList<>();
        tabs.add("笔记");
        tabs.add("收藏");
        tabs.add("赞过");
        MyAdapter adapter = new MyAdapter(requireActivity(), fragments);
        viewPager.setAdapter(adapter);
        //将tab和viewpager关联起来
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(tabs.get(position))).attach();
        return view;
    }
}