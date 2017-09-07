package com.example.shunsukesaito.sustainableweek;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by saitoushunsuke on 2017/09/07.
 */

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_likes:
                        Intent intent0 = new Intent(context,LikesActivity.class);
                        context.startActivity(intent0);
                        break;

                    case R.id.ic_main:
                        Intent intent1 = new Intent(context, MainActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_map:
                        Intent intent2 = new Intent(context, MapActivity.class);
                        context.startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }
}
