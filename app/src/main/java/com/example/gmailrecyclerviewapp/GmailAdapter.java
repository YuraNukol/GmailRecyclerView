package com.example.gmailrecyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class GmailAdapter extends RecyclerView.Adapter<GmailAdapter.ViewHolder> {

    private Inter inter;
    private ArrayList<ModelEmial> s;

    public GmailAdapter(ArrayList<ModelEmial> s, Inter inter) {
        this.s = s;
        this.inter = inter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_gmail_list,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvZag1.setText("Steam Store");
        viewHolder.tvZag2.setText("Ви продали предмет на ринку...");
        viewHolder.tvText.setText("Шановний YuraNykol Sed12 купє пр...");

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelEmial renameTxtBtn = s.get(position);
        holder.tvTime.setText(renameTxtBtn.getEmail());
        holder.tvZag1.setText(renameTxtBtn.getRtefd());
        staracivate(renameTxtBtn,holder.img_star);
        holder.img_star.setImageResource(renameTxtBtn.isSelected()?R.drawable.img_star_activate:R.drawable.img_star);
        holder.img_star.setOnClickListener(view -> staracivate(renameTxtBtn,holder.img_star));

    }

    @Override
    public int getItemCount() {
        return s.size();
    }

    private void staracivate(ModelEmial starAciv, ImageView img) {
        if(starAciv.isSelected()){
            img.setImageResource(R.drawable.img_star);
            starAciv.setSelected(false);
        }
        else {
            img.setImageResource(R.drawable.img_star_activate);
            starAciv.setSelected(true);
        }    }




    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_log;
        private ImageView img_star;
        private TextView tvZag1;
        private TextView tvZag2;
        private TextView tvText;
        private TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            img_log = itemView.findViewById(R.id.img_log);
            img_star = itemView.findViewById(R.id.img_star);

            tvZag1 = itemView.findViewById(R.id.tvZag1);
            tvZag2 = itemView.findViewById(R.id.tvZag2);
            tvText = itemView.findViewById(R.id.tvText);
            tvTime = itemView.findViewById(R.id.tvTime);

        }

    }
}
