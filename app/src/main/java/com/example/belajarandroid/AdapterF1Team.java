package com.example.belajarandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterF1Team extends RecyclerView.Adapter<AdapterF1Team.ViewHolder> {
    private List<F1Model> listData;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(F1Model F1);
    }

    public AdapterF1Team(List<F1Model> listData, OnItemClickListener listener) {
        this.listData = listData;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvTahun, tvNomor;
        ImageView imgF1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.valueNama);
            tvNomor = itemView.findViewById(R.id.valueNomor);
            tvTahun = itemView.findViewById(R.id.valueTahun);
            imgF1 = itemView.findViewById(R.id.imgF1);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_f1_team_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        F1Model F1 = listData.get(position);

        holder.tvNama.setText(F1.getNama());
        holder.tvTahun.setText(F1.getTahun());
        holder.tvNomor.setText(F1.getNomor());

        holder.imgF1.setImageResource(F1.getImg());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(F1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}