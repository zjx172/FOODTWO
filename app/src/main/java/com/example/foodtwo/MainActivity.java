package com.example.foodtwo;

import android.app.Activity;
import android.app.UiAutomation;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.jaeger.library.StatusBarUtil;


public class MainActivity extends AppCompatActivity {

    private TabFragment2 tabFragment2;
    private ListFragment listFragment;

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//        requestWindowFeature(Window.FEATURE_NO_TITLE);//去标题
        setContentView(R.layout.activity_main);
//        //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        //透明导航栏




//        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题


//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);




//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setTitle("App Title"); //设置Toolbar标题
//        mToolbar.setSubtitle("Sub Title"); //设置Toolbar 副标题
//        mToolbar.setLogo(R.mipmap.ic_launcher);//设置Toolbar的Logo
//        mToolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
//        setSupportActionBar(mToolbar);


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏




//        StatusBarCompat.setStatusBarColor(this, 000000);





        if(listFragment==null){
            listFragment = new ListFragment();
        }


        select(1);
        initView();












    }



    private void initView(){
        radioButton1=(RadioButton)findViewById(R.id.map_tab);
        Drawable drawable1=getResources().getDrawable(R.drawable.icon_map_default);
        drawable1.setBounds(0,0,60,60);
        radioButton1.setCompoundDrawables(null,drawable1,null,null);


        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioButton1.isChecked()==true){
                    Drawable drawable1=getResources().getDrawable(R.drawable.aixin_pressed);
                    drawable1.setBounds(0,0,60,60);;
                    radioButton1.setCompoundDrawables(null,drawable1,null,null);
                }else {
                    Drawable drawable1=getResources().getDrawable(R.drawable.icon_map_default);
                    drawable1.setBounds(0,0,60,60);
                    radioButton1.setCompoundDrawables(null,drawable1,null,null);
                }
            }
        });









        radioButton2=(RadioButton)findViewById(R.id.mine_tab);
        Drawable drawable3=getResources().getDrawable(R.mipmap.icon_mine_default);
        drawable3.setBounds(0,0,60,60);
        radioButton2.setCompoundDrawables(null,drawable3,null,null);
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioButton2.isChecked()==true){
                    Drawable drawable3=getResources().getDrawable(R.mipmap.wode_pressed);
                    drawable3.setBounds(0,0,60,60);
                    radioButton2.setCompoundDrawables(null,drawable3,null,null);
                }else {
                    Drawable drawable3=getResources().getDrawable(R.mipmap.icon_mine_default);
                    drawable3.setBounds(0,0,60,60);
                    radioButton2.setCompoundDrawables(null,drawable3,null,null);
                }
            }
        });



        radioButton3=(RadioButton)findViewById(R.id.info_tab);
        Drawable drawable2=getResources().getDrawable(R.mipmap.icon_info_default);
        drawable2.setBounds(0,0,60,60);
        radioButton3.setCompoundDrawables(null,drawable2,null,null);
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(radioButton3.isChecked()==true){
                    Drawable drawable2=getResources().getDrawable(R.mipmap.faxian_pressed);
                    drawable2.setBounds(0,0,60,60);
                    radioButton3.setCompoundDrawables(null,drawable2,null,null);
                }else {
                    Drawable drawable2=getResources().getDrawable(R.mipmap.icon_info_default);
                    drawable2.setBounds(0,0,60,60);
                    radioButton3.setCompoundDrawables(null,drawable2,null,null);
                }
            }
        });





        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select(1);

            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select(0);

            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select(1);



            }
        });




    }

    public void select(int i){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        switch (i){
            case 0:
            if(listFragment==null){
                listFragment = new ListFragment();
            }
                fragmentTransaction.replace(R.id.fragment_container,listFragment);
            break;
            case 1:
                if(tabFragment2==null){
                    tabFragment2=new TabFragment2();
                }
                fragmentTransaction.replace(R.id.fragment_container,tabFragment2);
                break;
                default:break;
        }
        fragmentTransaction.commit();
    }



}
