package com.example.foodtwo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodtwo.Bomb.Post;
import com.example.foodtwo.yuzhu.Send;
import com.yalantis.phoenix.PullToRefreshView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

import static android.widget.Toast.LENGTH_SHORT;

public class ListFragment1 extends Fragment {
    private RecyclerView listView;
    private SwipeRefreshLayout swipeRefresh;
    private PullToRefreshView mPullToRefreshView;
    private List<Post> list;
    private TextView yonghuming;
    private TextView wenzineirong;
    private ImageView neirong;
    private String imageUrl;
    private Bitmap bitmap;

    public ListFragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list1, container, false);




        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 500);
            }
        });
        listView = (RecyclerView) view.findViewById(R.id.listView);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        //   listView.setAdapter(new ListFragment1.MyAdapter());
        queryPage();

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


    private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            View button = itemView.findViewById(R.id.button3);
            yonghuming = (TextView) itemView.findViewById(R.id.yonghuming);
            wenzineirong = (TextView) itemView.findViewById(R.id.wenzineirong);
            neirong=(ImageView)itemView.findViewById(R.id.neirong);

            button.setOnClickListener(this);
        }

        boolean checked = false;
        public void onClick(View v) {
            if (v.getId() == R.id.button3) {
                if (checked == false) {
                    v.setBackgroundResource(R.drawable.ic_heart_red);
                    checked = true;
                } else {
                    v.setBackgroundResource(R.drawable.ic_heart_outline_grey);
                    checked = false;
                }

            }
        }
    }


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<Post> list = new ArrayList<>();

        public MyAdapter(List<Post> list) {
            this.list = list;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.list_item, viewGroup, false);
            MyViewHolder viewHolder = new MyViewHolder(view);

//            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });

            return viewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            Post postItem = list.get(i);
            yonghuming.setText(postItem.getTag());
            wenzineirong.setText(postItem.getText());
            BmobFile pic=postItem.getPicture();
            pic.download(new DownloadFileListener() {
                @Override
                public void done(String s, BmobException e) {
                    Toast.makeText(getActivity(), "已下载", Toast.LENGTH_LONG).show();
//                    imageUrl=s;
//                    Uri uri=Uri.parse(imageUrl);
//                    try {
//                        //Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
//                        bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uri);
//                    }catch (FileNotFoundException ss){
//                        ss.printStackTrace();
//                    }catch (IOException ee){ee.printStackTrace();}

                    // neirong.setImageURI();
                }
                @Override
                public void onProgress(Integer integer, long l) {

                }
            });

//            neirong.setImageBitmap(bitmap);



        }

    @Override
    public int getItemCount() {
        return list.size();
        //list.size();
    }

}



    //查询所有数据
    public void queryPage(){
        BmobQuery<Post> list = new BmobQuery<>();
        //查询存在“objectId”字段的数据。
        list.addWhereExists("objectId");
        //获取查询数据
        list.findObjects(new FindListener<Post>() {
            @Override
            public void done(List<Post> list, BmobException e) {
                if (e == null) {
                    try {
                        listView.setAdapter(new MyAdapter(list));
                        Toast.makeText(getActivity(), "更新列为" + list.size()+"条", Toast.LENGTH_LONG).show();
                    }catch (Exception es){
                        es.printStackTrace();
                    }
                }else {
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
