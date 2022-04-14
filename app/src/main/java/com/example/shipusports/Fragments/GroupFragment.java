package com.example.shipusports.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shipusports.adapters.ComAdapter;
import com.example.shipusports.objects.CommunityObj;
import com.example.shipusports.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class GroupFragment extends Fragment {

    private List<CommunityObj> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ComAdapter adapter;
    private View comView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        comView = inflater.inflate(R.layout.group_layout, container, false);
        initData();
        initRecyclerView();
        return comView;
    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) comView.findViewById(R.id.recycler_view_2);
        adapter = new ComAdapter(mList, getActivity());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }


    private void initData(){
        int i = 1;
        CommunityObj com1 = new CommunityObj("篮球", i++, R.drawable.bascket);
        mList.add(com1);
        CommunityObj com2 = new CommunityObj("滑板", i++, R.drawable.skid);
        mList.add(com2);
        CommunityObj com3 = new CommunityObj("橄榄球", i++, R.drawable.footb);
        mList.add(com3);
        CommunityObj com4 = new CommunityObj("网球", i++, R.drawable.tennis);
        mList.add(com4);
        CommunityObj com5 = new CommunityObj("赛车", i++, R.drawable.car);
        mList.add(com5);
        CommunityObj com6 = new CommunityObj("乒乓球", i++, R.drawable.ping_pong);
        mList.add(com6);

    }


}
