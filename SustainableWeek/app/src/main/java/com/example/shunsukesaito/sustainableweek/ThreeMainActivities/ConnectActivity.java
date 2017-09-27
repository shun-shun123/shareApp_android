package com.example.shunsukesaito.sustainableweek.ThreeMainActivities;

import android.content.Context;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.shunsukesaito.sustainableweek.JsonGetter;
import com.example.shunsukesaito.sustainableweek.R;
import com.example.shunsukesaito.sustainableweek.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectActivity extends AppCompatActivity{

    private Context mContext = ConnectActivity.this;

    private static final int ACTIVITY_NUM = 0;

    Animation animation;

    String str;

    /**
     * webAPIにpost、getする団体名と、いいね数
     */
    private final int add_likes = 1;
    String names[] = new String[17];
    String each_like[] = new String[17];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        final TextView organization = (TextView)findViewById(R.id.name);
        final TextView likes = (TextView)findViewById(R.id.likes);
        ImageButton apiSend = (ImageButton)findViewById(R.id.apiSend);

        setupBottomNavigationView();

        animation = AnimationUtils.loadAnimation(this,R.anim.likes_animation);



        /**
         * btnListenerApiSendを作る
         */
        View.OnClickListener btnListenerApiSend = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = organization.getText().toString();

//              final String sendData = String.format("{\"group\" : {\"name\" : \"%s\",\"likes\" : \"%d\" } }", name, add_likes);
                //APIを飛ばす処理
//                new AsyncTask<Void, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(Void... voids) {
//                        try {
//                            //byte配列に変換
//                            byte[] sendJson = sendData.getBytes("UTF-8");
//
//                            URL url = new URL("http://54.178.206.178/group/update");
//
//                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                            connection.setRequestMethod("POST");
//                            connection.setRequestProperty("Content-Type", "application/json");
//                            connection.setRequestProperty("Accept", "application/json");
//
//                            connection.setDoInput(true);
//                            connection.setDoOutput(true);
//
//
//                            connection.getOutputStream().write(sendJson);
//                            connection.getOutputStream().flush();
//                            connection.getOutputStream().close();
//
//                            connection.connect();
//                            connection.getResponseCode();
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        return null;
//                    }
//                }.execute();

                Log.d("Fucker", "onClick: ");

                /**
                 * データをgetするメソッド
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Fucker", "run: ");
                        try {
                            URL url = new URL("http://54.178.206.178/group/get");
                            HttpURLConnection con = (HttpURLConnection) url.openConnection();
                            str = InputStreamToString(con.getInputStream());
                            Log.d("Fucker", str);

                            /**
                             * 受け取ったJson型のデータを配列に入れ込んで、解析
                             */

                            //JSONObject jsRoot = new JSONObject(str);
                            Log.d("Fucker", "JSON object created");
                            JSONArray jsDataList = new JSONArray(str);

                            Log.d("Fucker", "Array finished");

                            for (int i = 0, jL = jsDataList.length(); i < jL; i++) {
                                JSONObject jsData = jsDataList.getJSONObject(i);
                                names[i] = jsData.getString("name");
                                each_like[i] = jsData.getString("likes");
                            }

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }


                    }
                }).start();


                /**
                 * 今選択中のgoalの名前と、いいね数を更新する
                 */
                switch (view.getId()){
                    case R.id.icon1:
                        organization.setText("貧困をなくそう");
                        likes.setText(each_like[0]);
                        break;
                    case R.id.icon2:
                        organization.setText("飢饉をゼロに");
                        likes.setText(each_like[1]);
                        break;
                    case R.id.icon3:
                        organization.setText("全ての人に健康と福祉を");
                        likes.setText(each_like[2]);
                        break;
                    case R.id.icon4:
                        organization.setText("質の高い教育をみんなに");
                        likes.setText(each_like[3]);
                        break;
                    case R.id.icon5:
                        organization.setText("ジェンダー平等を実現しよう");
                        likes.setText(each_like[4]);
                        break;
                    case R.id.icon6:
                        organization.setText("安全な水とトイレを世界中に");
                        likes.setText(each_like[5]);
                        break;
                    case R.id.icon7:
                        organization.setText("エネルギーをみんなに、そしてクリーンに");
                        likes.setText(each_like[6]);
                        break;
                    case R.id.icon8:
                        organization.setText("働きがいも経済成長も");
                        likes.setText(each_like[7]);
                        break;
                    case R.id.icon9:
                        organization.setText("産業と技術革新の基盤を作ろう");
                        likes.setText(each_like[8]);
                        break;
                    case R.id.icon10:
                        organization.setText("人や国の不平等をなくそう");
                        likes.setText(each_like[9]);
                        break;
                    case R.id.icon11:
                        organization.setText("住み続けられるまちづくりを");
                        likes.setText(each_like[10]);
                        break;
                    case R.id.icon12:
                        organization.setText("つくる責任、つかう責任");
                        likes.setText(each_like[11]);
                        break;
                    case R.id.icon13:
                        organization.setText("気候変動に具体的な対策を");
                        likes.setText(each_like[12]);
                        break;
                    case R.id.icon14:
                        organization.setText("海の豊かさを守ろう");
                        likes.setText(each_like[13]);
                        break;
                    case R.id.icon15:
                        organization.setText("緑の豊かさも守ろう");
                        likes.setText(each_like[14]);
                        break;
                    case R.id.icon16:
                        organization.setText("平和と公正を全ての人に");
                        likes.setText(each_like[15]);
                        break;
                    case R.id.icon17:
                        organization.setText("パートナーシップで目標を達成しよう");
                        likes.setText(each_like[16]);
                        break;

                }
            }
        };



        /**
         * ImageViewのViewを生成して、リスナーをセットして、webAPIにpost、getリクエストを送る
         */
        findViewById(R.id.icon1).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon2).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon3).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon4).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon5).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon6).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon7).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon8).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon9).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon10).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon11).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon12).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon13).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon14).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon15).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon16).setOnClickListener(btnListenerApiSend);
        findViewById(R.id.icon17).setOnClickListener(btnListenerApiSend);




        //likesボタンを押した時にapi通信をするためのメソッド
        apiSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //animation started
                view.startAnimation(animation);

                String name = organization.getText().toString();

                final String sendData = String.format("{\"group\" : {\"name\" : \"%s\",\"likes\" : \"%d\" } }",name,add_likes);
                //APIを飛ばす処理
                new AsyncTask<Void, Void, Void>(){
                    @Override
                    protected Void doInBackground(Void... voids) {
                        try{
                            //byte配列に変換
                            byte[] sendJson = sendData.getBytes("UTF-8");

                            URL url = new URL("http://54.178.206.178/group/update");

                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                            connection.setRequestMethod("POST");
                            connection.setRequestProperty("Content-Type", "application/json");
                            connection.setRequestProperty("Accept", "application/json");

                            connection.setDoInput(true);
                            connection.setDoOutput(true);


                            connection.getOutputStream().write(sendJson);
                            connection.getOutputStream().flush();
                            connection.getOutputStream().close();

                            connection.connect();
                            connection.getResponseCode();

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute();

                Log.d("Fucker", "onClick: ");

                /**
                 * データをgetするメソッド
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Fucker", "run: ");
                        try{
                            URL url = new URL("http://54.178.206.178/group/get");
                            HttpURLConnection con = (HttpURLConnection)url.openConnection();
                            str = InputStreamToString(con.getInputStream());
                            int like = Integer.parseInt(likes.getText().toString());
                            like++;
                            likes.setText(String.valueOf(like));

                            Log.d("Fucker", str);

                            /**
                             * 受け取ったJson型のデータを配列に入れ込んで、解析
                             */

                            //JSONObject jsRoot = new JSONObject(str);
                            Log.d("Fucker", "JSON object created");
                            JSONArray jsDataList = new JSONArray(str);

                            Log.d("Fucker", "Array finished");

                            for(int i = 0,jL = jsDataList.length();i < jL;i++){
                                JSONObject jsData = jsDataList.getJSONObject(i);
                                names[i] = jsData.getString("name");
                                each_like[i] = jsData.getString("likes");
                            }

                        }catch(Exception ex){
                            System.out.println(ex);
                        }



                    }
                }).start();


            }
        });
    }

    static String InputStreamToString(InputStream is) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
