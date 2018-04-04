package com.huzaifa.project.chatapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huzaifa.project.chatapp.R;

import java.util.ArrayList;

/**
 * Created by Muhammad Huzaifa on 2/21/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Viewholder> {

ArrayList<String> data;

    public PostAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
//        Picasso.with(holder.itemView.getContext()).load(R.id.icon_uri).into(holder.prof_pic);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView prof_pic;
        TextView t1,tweet;
        public Viewholder(View itemView) {
            super(itemView);
//            prof_pic = (ImageView) itemView.findViewById(R.id.img);
            t1 = (TextView) itemView.findViewById(R.id.txt);
            tweet = (TextView) itemView.findViewById(R.id.txt1);
        }
    }
}
