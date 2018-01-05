package com.example.root.recyclerviewbutthistimewithanimation0_0.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.recyclerviewbutthistimewithanimation0_0.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 6/1/18.
 */

public class RecyclerSimpleAdapter extends RecyclerView.Adapter<RecyclerSimpleAdapter.SimpleViewHolder> {

    List<Integer> dataSource;

    public RecyclerSimpleAdapter(){
        dataSource=new ArrayList<Integer>();
        for(int i=0;i<=10;i++)dataSource.add(i);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.textView.setText(String.valueOf(dataSource.get(position)));
    }


    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{


        TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
        }
    }

}
