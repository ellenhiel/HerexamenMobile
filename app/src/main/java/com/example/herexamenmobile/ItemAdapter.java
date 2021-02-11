package com.example.herexamenmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.NumberViewHolder> {
    private LayoutInflater Inflater;
    private Context context;
    private final LinkedList<Integer> testList;

    public ItemAdapter(Context context, LinkedList<Integer> testList){
        Inflater = LayoutInflater.from(context);
        this.context = context;
        this.testList = testList;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ItemView = Inflater.inflate(R.layout.itemview, parent, false);
        return new NumberViewHolder(ItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.NumberViewHolder holder, int position) {
        Integer currentNumber = testList.get(position);
        holder.Title.setText(currentNumber.toString());
    }

    @Override
    public int getItemCount() {
        return testList.size();
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