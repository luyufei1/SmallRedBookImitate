package com.example.smallredbookimitate.Fragment_toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.smallredbookimitate.Adapter.CardAdapter;
import com.example.smallredbookimitate.R;
import com.example.smallredbookimitate.bean.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FindFragment extends Fragment {

    private static final String TAG = "FindFragment";

    private Card[] cards = {new Card(R.drawable.image01, R.drawable.headimage01, "小卢快跑", "这是文章1这是文章1这是文章1这是文章1", 1212),
            new Card(R.drawable.image02, R.drawable.headimage02, "小马不怕跌倒", "这是文章2这是文章2这是文章2", 520),
            new Card(R.drawable.image03, R.drawable.headimage03, "想带上你私奔", "这是文章3这是文章3", 1123),
            new Card(R.drawable.image04, R.drawable.headimage04, "爱到1440", "这是文章4", 1440)};

    private List<Card> cardList = new ArrayList<>();
    private CardAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initCards();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CardAdapter(cardList);
        recyclerView.setAdapter(adapter);



        return view;
    }

    private void initCards() {
        cardList.clear();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int index = random.nextInt(4);
            cardList.add(cards[index]);
        }
    }
}