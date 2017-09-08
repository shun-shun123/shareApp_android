package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import com.nifty.cloud.mb.core.NCMB;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.shunsukesaito.sustainableweek.Utils.BottomNavigationViewHelper;
import com.example.shunsukesaito.sustainableweek.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class LikesActivity extends AppCompatActivity {

    private Context mContext = LikesActivity.this;

    private static final int ACTIVITY_NUM = 0;




    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

        //mBaasサーバと通信を行うための初期化
        NCMB.initialize(this.getApplicationContext(),"77dc63ab551f20262259b4ae925f6908c0e835faca51b53fe090d4e8e849ecd9","62332cd03b736d23c19e27e8ddebcab37d56732389f3f2c79c07a559a6838677");



        button = (Button) findViewById(R.id.connect);

        setupBottomNavigationView();
    }

    public void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
}
