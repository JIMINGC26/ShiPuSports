package com.example.shipusports.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shipusports.activities.CommunityActivity;
import com.example.shipusports.R;
import com.example.shipusports.objects.CommunityObj;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ComAdapter extends RecyclerView.Adapter<ComAdapter.ViewHolder> {

    List<CommunityObj> mList = new ArrayList<>();
    Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView comImg;
        TextView comText;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            comImg = (ImageView) itemView.findViewById(R.id.com_img_id);
            comText = (TextView) itemView.findViewById(R.id.com_text_id);
        }
    }

    public ComAdapter(List<CommunityObj> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommunityObj com = mList.get(position);
        Glide.with(context).load(com.getImgId()).into(holder.comImg);
        holder.comText.setText(com.getCname());
        holder.cardView.setOnClickListener((view)->{
            Intent intent = new Intent(context, CommunityActivity.class);
            intent.putExtra("CName",com.getCname());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
