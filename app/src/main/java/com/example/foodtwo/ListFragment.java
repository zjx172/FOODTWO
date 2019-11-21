package com.example.foodtwo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private  TabLayout mTabLayout;
    private  ViewPager mViewPager;
    FragmentPagerAdapter mAdapter;//这你都有。。

//    private RecyclerView[] listViews;
    private RecyclerView listView;
//    private ViewPager viewPager;
    public ListFragment() {
        // Required empty public constructor
//        listViews[0]=new RecyclerView(getContext());
//        listViews[1]=new RecyclerView(getContext());
//        listViews[2]=new RecyclerView(getContext());
//
//        listViews[0].setBackgroundColor(Color.RED);
//        listViews[1].setBackgroundColor(Color.GRAY);
//        listViews[2].setBackgroundColor(Color.BLUE);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_list,container,false);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
//        mTabLayout.addTab(mTabLayout.newTab().setText("我发布的"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("我喜欢的"));
//
//        viewPager= view.findViewById(R.id.viewpager);
//        viewPager.setAdapter(new ViewPagerAdapter());

        List<Fragment>fragements=new ArrayList<Fragment>();
        fragements.add(new ListFragment1());
        fragements.add(new ListFragment1());



        mViewPager=(ViewPager)view.findViewById(R.id.viewPager);


        FragmentManager man =this.getChildFragmentManager();
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        mAdapter=new FragmentAdapter(man,fragements);

        mViewPager.setAdapter(mAdapter);
//
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);




        return view;
    }

    public class FragmentAdapter extends FragmentPagerAdapter {
        private String [] title = {"我发布的","我喜欢的"};
        private List<Fragment> fragmentList;
        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);//或返回具体的fragment并传值
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }


//    public class ViewPagerAdapter extends PagerAdapter {
//        ViewPagerAdapter(){
//
//        }
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//
//        @Override
//        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//            return false;
//        }
//
//        @NonNull
//        @Override
//        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
//        }
//
//        @Override
//        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
//        }
//    }

}
