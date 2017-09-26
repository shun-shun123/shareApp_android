package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMB;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
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

    public int AllLikes = 0;

    //Mbaasサーバとコネクトするためのボタン
    ImageButton connect;
    //現在のLikes数を表示するためのテキストビュー
    TextView counter;
    //Likes数を増やすためのボタン
     ImageButton likes;
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


        adapter.add("MERCI");
        adapter.add("水質研究セミナー");
        adapter.add("STEP");
        adapter.add("haconiwa");
        adapter.add("Reco.lab");
        adapter.add("Acoustic Guitar Circle");
        adapter.add("PASTEL");
        adapter.add("Dive in Blue");
        adapter.add("FB+1");
        adapter.add("Song Genics");
        adapter.add("watnow");
        adapter.add("Ritree");
        adapter.add("DANDELION");
        adapter.add("Color Guard Circle Laster");
        adapter.add("ivusa");
        adapter.add("世界報道写真展");
        adapter.add("くさてん");
        adapter.add("BKCI");
        adapter.add("月光斜");
        adapter.add("SOIL&SOUL");
        adapter.add("color free");
        adapter.add("RRST");
        adapter.add("EMH PROJECT");

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
        connect = (ImageButton) findViewById(R.id.connect);
        counter = (TextView) findViewById(R.id.counter);
        likes = (ImageButton) findViewById(R.id.likes);
        organization = (TextView) findViewById(R.id.organization);



        /**
         * テキストビューに現在のlikes数を記載する
         */
        likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPushedAnimation(view);
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
                onPushedAnimation(view);
                obj.put("key",key);
                obj.put("value",likes);
                obj.saveInBackground(new DoneCallback() {
                    @Override
                    public void done(NCMBException e) {
                        if (e != null) {
                            //エラー発生時の処理
                            Toast toast = Toast.makeText(LikesActivity.this,"送信失敗",Toast.LENGTH_LONG);
                            toast.show();
                        } else {

                            //成功時の処理
                            Toast toast = Toast.makeText(LikesActivity.this,"送信完了",Toast.LENGTH_SHORT);
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


    /**
     * いいねボタンを押した時のアニメーションを行うためのメソッド
     * @param view
     * viewは引数として受け取るImageButton（いいねボタン）
     */
    public void onPushedAnimation(View view){
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.3f,1.0f,1.3f,view.getWidth()/2,view.getHeight()/2);
        scaleAnimation.setDuration(100);
        scaleAnimation.setFillAfter(false);
        view.startAnimation(scaleAnimation);
    }


}



