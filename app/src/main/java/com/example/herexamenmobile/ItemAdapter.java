package com.example.herexamenmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.NumberViewHolder> {
    private LayoutInflater Inflater;
    private Context context;
    ArrayList<Projects> projectList;

    public ItemAdapter(Context context, ArrayList<Projects> projectList){
        Inflater = LayoutInflater.from(context);
        this.context = context;
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ItemView = Inflater.inflate(R.layout.itemview, parent, false);
        return new NumberViewHolder(ItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.NumberViewHolder holder, int position) {
        final Projects currentProject = projectList.get(position);
        holder.Title.setText(currentProject.getTitle());

        holder.Layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, item_detail.class);

                intent.putExtra("title", currentProject.getTitle());
                intent.putExtra("description", currentProject.getDescription());
                intent.putExtra("url", currentProject.getUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    static class NumberViewHolder extends RecyclerView.ViewHolder{
        final ItemAdapter Adapter;
        public final TextView Title;
        public final FrameLayout Layout;

        public NumberViewHolder(@NonNull View itemView, @NonNull ItemAdapter adapter) {
            super(itemView);
            Adapter = adapter;
            Title = itemView.findViewById(R.id.title);
            Layout = itemView.findViewById(R.id.layout);
        }
    }
}