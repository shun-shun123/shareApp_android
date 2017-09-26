package com.example.shunsukesaito.sustainableweek.Utils;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.shunsukesaito.sustainableweek.R;


import org.json.JSONObject;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<JSONObject> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        final TextView organization = (TextView)findViewById(R.id.name);
        final TextView likes = (TextView)findViewById(R.id.likes);
        ImageButton apiSend = (ImageButton)findViewById(R.id.apiSend);

        //likesボタンを押した時にapi通信をするためのメソッド
        apiSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = organization.getText().toString();
                int total_likes = Integer.parseInt(likes.getText().toString());

                final String sendData = String.format("{\"group\" : {\"name\" : \"%s\",\"likes\" : \"%d\" } }",name,total_likes);
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

            }
        });

        getLoaderManager().restartLoader(1, null, ConnectActivity.this);
    }
}
