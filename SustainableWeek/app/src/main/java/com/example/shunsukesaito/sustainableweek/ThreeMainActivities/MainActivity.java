package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.shunsukesaito.sustainableweek.Posters.Poster01;
import com.example.shunsukesaito.sustainableweek.Posters.Poster02;
import com.example.shunsukesaito.sustainableweek.Posters.Poster03;
import com.example.shunsukesaito.sustainableweek.Posters.Poster04;
import com.example.shunsukesaito.sustainableweek.Posters.Poster05;
import com.example.shunsukesaito.sustainableweek.Posters.Poster06;
import com.example.shunsukesaito.sustainableweek.Posters.Poster07;
import com.example.shunsukesaito.sustainableweek.Posters.Poster08;
import com.example.shunsukesaito.sustainableweek.Posters.Poster09;
import com.example.shunsukesaito.sustainableweek.Posters.Poster10;
import com.example.shunsukesaito.sustainableweek.Posters.Poster11;
import com.example.shunsukesaito.sustainableweek.Posters.Poster12;
import com.example.shunsukesaito.sustainableweek.Posters.Poster13;
import com.example.shunsukesaito.sustainableweek.Posters.Poster14;
import com.example.shunsukesaito.sustainableweek.Posters.Poster15;
import com.example.shunsukesaito.sustainableweek.Posters.Poster16;
import com.example.shunsukesaito.sustainableweek.Posters.Poster17;
import com.example.shunsukesaito.sustainableweek.Utils.BottomNavigationViewHelper;
import com.example.shunsukesaito.sustainableweek.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;

    private static final int ACTIVITY_NUM = 1;

    View.OnClickListener iconClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id){
                case R.id.icon1:
                    Intent intent01 = new Intent(MainActivity.this, Poster01.class);
                    startActivity(intent01);
                    break;

                case R.id.icon2:
                    Intent intent02 = new Intent(MainActivity.this, Poster02.class);
                    startActivity(intent02);
                    break;

                case R.id.icon3:
                    Intent intent03 = new Intent(MainActivity.this, Poster03.class);
                    startActivity(intent03);
                    break;

                case R.id.icon4:
                    Intent intent04 = new Intent(MainActivity.this, Poster04.class);
                    startActivity(intent04);
                    break;

                case R.id.icon5:
                    Intent intent05 = new Intent(MainActivity.this, Poster05.class);
                    startActivity(intent05);
                    break;

                case R.id.icon6:
                    Intent intent06 = new Intent(MainActivity.this, Poster06.class);
                    startActivity(intent06);
                    break;

                case R.id.icon7:
                    Intent intent07 = new Intent(MainActivity.this, Poster07.class);
                    startActivity(intent07);
                    break;

                case R.id.icon8:
                    Intent intent08 = new Intent(MainActivity.this, Poster08.class);
                    startActivity(intent08);
                    break;

                case R.id.icon9:
                    Intent intent09 = new Intent(MainActivity.this, Poster09.class);
                    startActivity(intent09);
                    break;

                case R.id.icon10:
                    Intent intent10 = new Intent(MainActivity.this, Poster10.class);
                    startActivity(intent10);
                    break;

                case R.id.icon11:
                    Intent intent11 = new Intent(MainActivity.this, Poster11.class);
                    startActivity(intent11);
                    break;

                case R.id.icon12:
                    Intent intent12 = new Intent(MainActivity.this, Poster12.class);
                    startActivity(intent12);
                    break;

                case R.id.icon13:
                    Intent intent13 = new Intent(MainActivity.this, Poster13.class);
                    startActivity(intent13);
                    break;

                case R.id.icon14:
                    Intent intent14 = new Intent(MainActivity.this, Poster14.class);
                    startActivity(intent14);
                    break;

                case R.id.icon15:
                    Intent intent15 = new Intent(MainActivity.this, Poster15.class);
                    startActivity(intent15);
                    break;

                case R.id.icon16:
                    Intent intent16 = new Intent(MainActivity.this, Poster16.class);
                    startActivity(intent16);
                    break;

                case R.id.icon17:
                    Intent intent17 = new Intent(MainActivity.this, Poster17.class);
                    startActivity(intent17);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigationView();

        //ImageButtonをとにかく生成
        ImageButton icon01 = (ImageButton) findViewById(R.id.icon1);
        ImageButton icon02 = (ImageButton) findViewById(R.id.icon2);
        ImageButton icon03 = (ImageButton) findViewById(R.id.icon3);
        ImageButton icon04 = (ImageButton) findViewById(R.id.icon4);
        ImageButton icon05 = (ImageButton) findViewById(R.id.icon5);
        ImageButton icon06 = (ImageButton) findViewById(R.id.icon6);
        ImageButton icon07 = (ImageButton) findViewById(R.id.icon7);
        ImageButton icon08 = (ImageButton) findViewById(R.id.icon8);
        ImageButton icon09 = (ImageButton) findViewById(R.id.icon9);
        ImageButton icon10 = (ImageButton) findViewById(R.id.icon10);
        ImageButton icon11 = (ImageButton) findViewById(R.id.icon11);
        ImageButton icon12 = (ImageButton) findViewById(R.id.icon12);
        ImageButton icon13 = (ImageButton) findViewById(R.id.icon13);
        ImageButton icon14 = (ImageButton) findViewById(R.id.icon14);
        ImageButton icon15 = (ImageButton) findViewById(R.id.icon15);
        ImageButton icon16 = (ImageButton) findViewById(R.id.icon16);
        ImageButton icon17 = (ImageButton) findViewById(R.id.icon17);

        //全てのImageButtonに画面遷移のためのリスナーをつける
        icon01.setOnClickListener(iconClickListener);
        icon02.setOnClickListener(iconClickListener);
        icon03.setOnClickListener(iconClickListener);
        icon04.setOnClickListener(iconClickListener);
        icon05.setOnClickListener(iconClickListener);
        icon06.setOnClickListener(iconClickListener);
        icon07.setOnClickListener(iconClickListener);
        icon08.setOnClickListener(iconClickListener);
        icon09.setOnClickListener(iconClickListener);
        icon10.setOnClickListener(iconClickListener);
        icon11.setOnClickListener(iconClickListener);
        icon12.setOnClickListener(iconClickListener);
        icon13.setOnClickListener(iconClickListener);
        icon14.setOnClickListener(iconClickListener);
        icon15.setOnClickListener(iconClickListener);
        icon16.setOnClickListener(iconClickListener);
        icon17.setOnClickListener(iconClickListener);



    }


    public void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}
