package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMB;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shunsukesaito.sustainableweek.Utils.BottomNavigationViewHelper;
import com.example.shunsukesaito.sustainableweek.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

public class LikesActivity extends AppCompatActivity {

    private Context mContext = LikesActivity.this;

    private static final int ACTIVITY_NUM = 0;

    public int AllLikes = 1;

    View.OnClickListener selectOrganization = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.watnow:
                    organization.setText("watnow");
                    break;
                case R.id.step:
                    organization.setText("step");
                    break;

            }
        }
    };



    //Mbaasサーバとコネクトするためのボタン
    Button connect;
    //現在のLikes数を表示するためのテキストビュー
    TextView counter;
    //Likes数を増やすためのボタン
    Button likes;
    //団体名をkeyとして取得するためのボタン
    Button watnow;
    Button step;
    TextView organization;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

        //mBaasサーバと通信を行うための初期化
        NCMB.initialize(this.getApplicationContext(),"77dc63ab551f20262259b4ae925f6908c0e835faca51b53fe090d4e8e849ecd9","62332cd03b736d23c19e27e8ddebcab37d56732389f3f2c79c07a559a6838677");


        /**
         * 使うViewウィジェットの初期化
         */
        connect = (Button) findViewById(R.id.connect);
        counter = (TextView) findViewById(R.id.counter);
        likes = (Button) findViewById(R.id.likes);
        watnow = (Button) findViewById(R.id.watnow);
        watnow.setOnClickListener(selectOrganization);
        step = (Button) findViewById(R.id.step);
        step.setOnClickListener(selectOrganization);
        organization = (TextView) findViewById(R.id.organization);



        /**
         * テキストビューに現在のlikes数を記載する
         */
        likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllLikes++;
                counter.setText(String.valueOf(AllLikes) );
            }
        });

        /**
         * mBaasサーバとの通信をし、likes数をpushするメソッド
         */
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int likes = Integer.parseInt(counter.getText().toString());
                String key = organization.getText().toString();
                NCMBObject obj = new NCMBObject("SaveObjectTest");
                obj.put("key",key);
                obj.put("value",likes);
                obj.saveInBackground(new DoneCallback() {
                    @Override
                    public void done(NCMBException e) {
                        if (e != null) {
                            //エラー発生時の処理
                            Toast toast = Toast.makeText(LikesActivity.this,"失敗",Toast.LENGTH_LONG);
                            toast.setMargin(100,100);
                            toast.show();
                        } else {

                            //成功時の処理
                            Toast toast = Toast.makeText(LikesActivity.this,"成功",Toast.LENGTH_SHORT);
                            toast.setMargin(100,100);
                            toast.show();
                        }
                    }
                });
            }
        });


        //BottomNavigationViewのselectedの実装
        setupBottomNavigationView();
    }


    /**
     * BottomNavigationViewのアイコンをselectedするためのメソッド
     */
    public void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
}
