package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.shunsukesaito.sustainableweek.Utils.BottomNavigationViewHelper;
import com.example.shunsukesaito.sustainableweek.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MapActivity extends AppCompatActivity {


    private Context mContext = MapActivity.this;

    private static final int ACTIVITY_NUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

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
