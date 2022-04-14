package com.example.shipusports.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shipusports.objects.PostObj;
import com.example.shipusports.adapters.PostObjAdapter;
import com.example.shipusports.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MsgFragment extends Fragment {

    private List<PostObj> postObjList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PostObjAdapter adapter;
    private FloatingActionButton goTopButton;
    private View msgView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        msgView = inflater.inflate(R.layout.msg_layout, container, false);
        initPost();
        initRecyclerView();
        return msgView;
    }


    private void initRecyclerView(){
        goTopButton = (FloatingActionButton) msgView.findViewById(R.id.float_button_upback);
        goTopButton.setVisibility(View.GONE);
        recyclerView = (RecyclerView) msgView.findViewById(R.id.recycler_view_1);
        adapter = new PostObjAdapter(postObjList, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE){ //检测是否滑动
                    if (firstVisibleItemPosition == 0) {    //处于顶部隐藏按钮
                        goTopButton.setVisibility(View.GONE);
                    }else {
                        goTopButton.setVisibility(View.VISIBLE);
                    }
                }else {
                    goTopButton.setVisibility(View.GONE); //未滑动
                }

            }
        });

        goTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(0);
                goTopButton.setVisibility(View.GONE);
            }
        });

    }

    private void initPost(){
        for(int i = 0; i < 30; i++){
            PostObj post = new PostObj(i+1, "This is news title "+i, "This is the content of news "+ i + " ");
            postObjList.add(post);
        }
    }
}

