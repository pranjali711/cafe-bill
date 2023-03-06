package com.karan.cafebill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    ArrayList<History> arrayList;
    public HistoryAdapter(ArrayList<History> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {

        String name=arrayList.get(position).getOrderno();
        String price=arrayList.get(position).getTotalamount();
        holder.itemname.setText("#"+name);
        holder.itemprice.setText(price);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemname,itemprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname=itemView.findViewById(R.id.item_name);
            itemprice=itemView.findViewById(R.id.item_price);
        }
    }
}

