package com.example.shipusports.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shipusports.activities.PostActivity;
import com.example.shipusports.R;
import com.example.shipusports.objects.PostObj;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PostObjAdapter extends RecyclerView.Adapter<PostObjAdapter.ViewHolder> {

    private List<PostObj> mPostList;
    private Context context;



    static class ViewHolder extends RecyclerView.ViewHolder{
        View PostView;
        TextView title;
        TextView content;
        Button sc_btn;
        Button dz_btn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            PostView = itemView;
            title = (TextView) itemView.findViewById(R.id.title_id);
            content = (TextView) itemView.findViewById(R.id.content_id);
            dz_btn = (Button) itemView.findViewById(R.id.btn_dz);
            sc_btn = (Button) itemView.findViewById(R.id.btn_sc);
        }
    }

    public PostObjAdapter(List<PostObj> mPostList, Context context){
        this.mPostList = mPostList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostObj post = mPostList.get(position);
        holder.title.setText(post.getTitle());
        holder.content.setText(post.getContent());
        int i = position;

        holder.PostView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostActivity.class);
                String title = mPostList.get(i).getTitle();
                String content = mPostList.get(i).getContent();
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                context.startActivity(intent);
            }
        });

        holder.dz_btn.setOnClickListener((view)->{
            if (holder.dz_btn.getText().equals(" ")){
                Toast.makeText(context, "点赞成功!", Toast.LENGTH_SHORT).show();
                holder.dz_btn.setBackgroundResource(R.drawable.like);
                holder.dz_btn.setText("  ");
            } else if (holder.dz_btn.getText().equals("  ")) {
                Toast.makeText(context, "取消点赞!", Toast.LENGTH_SHORT).show();
                holder.dz_btn.setBackgroundResource(R.drawable.unlike);
                holder.dz_btn.setText(" ");
            }
        });

        holder.sc_btn.setOnClickListener((view)->{
            if (holder.sc_btn.getText().equals(" ")){
                Toast.makeText(context, "收藏成功！", Toast.LENGTH_SHORT).show();
                holder.sc_btn.setBackgroundResource(R.drawable.favorite);
                holder.sc_btn.setText("  ");
            }else if (holder.sc_btn.getText().equals("  ")){
                Toast.makeText(context, "取消收藏！", Toast.LENGTH_SHORT).show();
                holder.sc_btn.setBackgroundResource(R.drawable.unfavorite);
                holder.sc_btn.setText(" ");
            }
        });


    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }


}

