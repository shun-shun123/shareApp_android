package com.example.shunsukesaito.sustainableweek;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private Context mContext = MainActivity.this;

    private static final int ACTIVITY_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigationView();

        ImageButton poster1 = (ImageButton) findViewById(R.id.icon1);
        View.OnClickListener btnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PosterFragment fragmentPoster1 = new PosterFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container,fragmentPoster1);
                transaction.commit();
            }
        };

        poster1.setOnClickListener(btnClickListener);


    }


    public void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }

}
