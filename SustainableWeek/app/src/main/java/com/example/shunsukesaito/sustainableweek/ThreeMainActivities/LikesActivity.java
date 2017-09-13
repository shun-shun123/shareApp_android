package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMB;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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

    //Mbaasサーバとコネクトするためのボタン
    Button connect;
    //現在のLikes数を表示するためのテキストビュー
    TextView counter;
    //Likes数を増やすためのボタン
    Button likes;
    //選択中の団体名を表示するためのテキストビュー
    TextView organization;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

        /**
         * Spinner用のAdapterを作る
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        adapter.add("STEP");
        adapter.add("watnow");
        adapter.add("草津天文研究会");
        adapter.add("SOIL&SOUL");
        adapter.add("RRST");
        adapter.add("Tisa");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner.getSelectedItem();
                organization.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        //mBaasサーバと通信を行うための初期化
        NCMB.initialize(this.getApplicationContext(),"77dc63ab551f20262259b4ae925f6908c0e835faca51b53fe090d4e8e849ecd9","62332cd03b736d23c19e27e8ddebcab37d56732389f3f2c79c07a559a6838677");


        /**
         * 使うViewウィジェットの初期化
         */
        connect = (Button) findViewById(R.id.connect);
        counter = (TextView) findViewById(R.id.counter);
        likes = (Button) findViewById(R.id.likes);
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
                            counter.setText(String.valueOf(0) );
                            AllLikes = 0;
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
