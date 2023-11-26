package com.example.smallredbookimitate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallredbookimitate.R;
import com.example.smallredbookimitate.bean.Message_item;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Message_item_adapter extends RecyclerView.Adapter<Message_item_adapter.ViewHolder> {

    private List<Message_item> mMessageList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_itm,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message_item message_item = mMessageList.get(position);
        holder.image.setImageResource(message_item.getImageId());
        holder.title.setText(message_item.getTitle());
        holder.content.setText(message_item.getContent());
        holder.time.setText(message_item.getTime());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView title;
        TextView content;
        TextView time;

        public ViewHolder(View view){
            super(view);
            image = (CircleImageView) view.findViewById(R.id.message_image);
            title = (TextView) view.findViewById(R.id.message_title);
            content = (TextView) view.findViewById(R.id.message_content);
            time = (TextView) view.findViewById(R.id.message_time);
        }
    }

    public Message_item_adapter(List<Message_item> mMessageList) {
        this.mMessageList = mMessageList;
    }
}
