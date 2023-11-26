package com.example.smallredbookimitate.Fragment_nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallredbookimitate.Adapter.Message_item_adapter;
import com.example.smallredbookimitate.R;
import com.example.smallredbookimitate.bean.Message_item;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {

    private List<Message_item> messageItemList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initItem();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.message_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Message_item_adapter adapter = new Message_item_adapter(messageItemList);
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void initItem(){
        Message_item firstItem = new Message_item(R.drawable.messageimage01,"小红书","欢迎来到小红书","星期一");
        Message_item secondItem = new Message_item(R.drawable.messageimage02,"麻琪","要一起去散步吗","刚刚");
        Message_item thirdItem = new Message_item(R.drawable.messageimage03,"字节跳动","什么时候来上班","星期一");
        Message_item forthItem = new Message_item(R.drawable.messageimage04,"抖音","快来发布你的视频吧","星期日");
        messageItemList.add(firstItem);
        messageItemList.add(secondItem);
        messageItemList.add(thirdItem);
        messageItemList.add(forthItem);
    }
}