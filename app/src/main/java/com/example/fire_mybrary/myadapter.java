package com.example.fire_mybrary;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {



    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);

       return new myviewholder(view);
    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder,@NonNull final int position, @NonNull final model model) {
        holder.title.setText(model.getTitle());
        holder.des.setText(model.getDes());
        holder.genre.setText(model.getGenre());
        Glide.with(holder.image.getContext()).load(model.getImage()).into(holder.image);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View view) {
//                String gTitle = model.getTitle();
//                String gDescription = model.getDes();
//                String gImageView = model.getImage();
//                Intent intent = new Intent(myadapter.this,AnotherActivity.class);
//                intent.putExtra("iTitle",gTitle);
//                intent.putExtra("iDescription", gDescription);
//                intent.putExtra("iImageView", gImageView);
//                myadapter.startActivity(intent);
//
//            }
//
//
//        });
    }


    class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, des, genre;
        View v;

        public myviewholder(@NonNull View itemView) {

            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img1);
            title = (TextView) itemView.findViewById(R.id.nametext);
            des = (TextView) itemView.findViewById(R.id.coursetext);
            genre = (TextView) itemView.findViewById(R.id.emailtext);
            v = itemView;
        }


    }

}
