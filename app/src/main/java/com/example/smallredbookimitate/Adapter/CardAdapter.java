package com.example.smallredbookimitate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smallredbookimitate.R;
import com.example.smallredbookimitate.bean.Card;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context mcontext;
    private List<Card> mCardList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        ImageView cardImage;
        TextView title;
        TextView name;
        CircleImageView headPicture;
        TextView like;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            cardImage = (ImageView) view.findViewById(R.id.card_image);
            title = (TextView) view.findViewById(R.id.card_title);
            name = (TextView) view.findViewById(R.id.card_username);
            headPicture = (CircleImageView) view.findViewById(R.id.card_headpicture);
            like = (TextView) view.findViewById(R.id.card_likenumber);
        }
    }

    public CardAdapter(List<Card> mCardList) {
        this.mCardList = mCardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mcontext == null) {
            mcontext = parent.getContext();
        }
        View view = LayoutInflater.from(mcontext).inflate(R.layout.adapter_item_card, parent, false);

        //设置随机高度
        ImageView imageView = view.findViewById(R.id.card_image);
        ViewGroup.LayoutParams lp = imageView.getLayoutParams();
        int scale = new Random().nextInt(10);
        if(scale < 5){
            scale = 9;
        }
        lp.height= 65 * scale;
        imageView.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = mCardList.get(position);
        holder.title.setText(card.getTitle());
        holder.like.setText(card.getLikes() + "");
        holder.name.setText(card.getName());
        Glide.with(mcontext).load(card.getImageId()).into(holder.cardImage);
        Glide.with(mcontext).load(card.getHeadId()).into(holder.headPicture);
    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }
}
