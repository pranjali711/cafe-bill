package com.karan.cafebill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    ArrayList<orderlist> arrayList;
    public MainAdapter(ArrayList<orderlist> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        String name=arrayList.get(position).getItemname();
        int price=arrayList.get(position).getPrice();
        holder.itemname.setText(name);
        holder.itemprice.setText(price+"");
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
