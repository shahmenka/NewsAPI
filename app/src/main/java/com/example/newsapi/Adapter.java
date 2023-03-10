package com.example.newsapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.listitem,null,false);
        return new ViewHolder (view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (context,webView.class);
                i.putExtra ("url",modelClassArrayList.get (position).getUrl ());
                context.startActivity (i);
            }
        });
         holder.mtime.setText("Published At:-" + modelClassArrayList.get(position).getPublishedAt ());
         holder.mauthor.setText (modelClassArrayList.get (position).getAuthor ());
         holder.mcontent.setText (modelClassArrayList.get (position).getDescription ());
         holder.mHeading.setText (modelClassArrayList.get (position).getTitle ());
        Glide.with (context).load (modelClassArrayList.get (position).getUrlToImage ()).into (holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mHeading, mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super (itemView);
            mHeading = itemView.findViewById (R.id.mainHeading);
            mauthor = itemView.findViewById (R.id.author);
            mcontent = itemView.findViewById (R.id.contents);
            mtime = itemView.findViewById (R.id.time);
            cardView = itemView.findViewById (R.id.cardView);
            imageView = itemView.findViewById (R.id.imageview);





        }
    }
}
