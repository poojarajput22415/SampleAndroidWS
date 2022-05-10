package com.example.samplemvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> dataList = new ArrayList<>();

    public void updateAdapterData(List<String> dataList){

        this.dataList = dataList;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_view,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = new ViewHolder(holder.itemView);

        viewHolder.onBindData(dataList.get(position));

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvRowData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRowData = (TextView) itemView.findViewById(R.id.tvRowData);
        }

        private void onBindData(String data){
            tvRowData.setText(data);
        }
    }
}
