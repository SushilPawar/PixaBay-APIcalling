package com.example.advancetopics.Json_parsing;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.advancetopics.Custom_adapter;
import com.example.advancetopics.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Pixabay_adapter extends RecyclerView.Adapter<Pixabay_adapter.holder> {
    Context context;
    ArrayList<Pixabay_model> arrayList;

    public Pixabay_adapter(Context context, ArrayList<Pixabay_model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pixabay_row,null,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        Pixabay_model temp = arrayList.get(position);
        int likecount =temp.getLikes();
        String imageurl  = temp.getImageurl();

        holder.creator.setText(temp.getCreator());
        holder.likes.setText("Likes: "+likecount);
        Picasso.with(context).load(imageurl).fit().centerInside().into(holder.catimage);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Pixabay_details.class);
                intent.putExtra("image",temp.getImageurl());
                intent.putExtra("creator",temp.getCreator());
                intent.putExtra("likes",temp.getLikes());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        ImageView catimage;
        TextView creator,likes;
        CardView card;
        public holder(@NonNull View itemView) {
            super(itemView);

            catimage = itemView.findViewById(R.id.imageview);
            creator = itemView.findViewById(R.id.creator);
            likes = itemView.findViewById(R.id.likes);
            card = itemView.findViewById(R.id.pixabaycard);

        }
    }
}
