package com.example.foodtwo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yalantis.phoenix.PullToRefreshView;

public class ListFragment1 extends Fragment {
    private RecyclerView listView;
    private SwipeRefreshLayout swipeRefresh;
    private PullToRefreshView mPullToRefreshView;

    public ListFragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list1,container,false);


        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                },500);
            }
        });
        listView=(RecyclerView)view.findViewById(R.id.listView);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setAdapter(new ListFragment1.MyAdapter());
//
//        swipeRefresh=(SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
//        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark));
//        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//            }
//        });





        return view;
    }



    private class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView){
            super(itemView);
        }
    }




    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater inflater=getLayoutInflater(null);
            View view=inflater.inflate(R.layout.list_item,viewGroup,false);

            MyViewHolder viewHolder=new MyViewHolder(view);


            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }
}
