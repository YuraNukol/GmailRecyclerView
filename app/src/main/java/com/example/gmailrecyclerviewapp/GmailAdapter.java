package com.example.gmailrecyclerviewapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    private ArrayList<String> s;
    private boolean starAciv =false;

    public GmailAdapter(ArrayList<String> s, Inter inter) {
        this.s = s;
        this.inter = inter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_gmail_list;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tvZag1.setText("Steam Store");
        viewHolder.tvZag2.setText("Ви продали предмет на ринку...");
        viewHolder.tvText.setText("Шановний YuraNykol Sed12 купє пр...");

        for (int i=0; i<10;i++)
        viewHolder.tvTime.setText("1"+(i+2)+i+"0");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String renameTxtBtn = s.get(position);
        holder.tvTime.setText(renameTxtBtn);


        holder.img_star.setOnClickListener(view -> starAcivate(holder.img_star));

    }

    @Override
    public int getItemCount() {
        return s.size();
    }

    private void starAcivate(ImageView img) {


        if(starAciv==false){
            img.setImageResource(R.drawable.img_star_activate);
            starAciv=true;
        }
        else {
            img.setImageResource(R.drawable.img_star);
            starAciv=false;
        }

    }




    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_log, img_star;
        private TextView tvZag1, tvZag2, tvText, tvTime;

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
