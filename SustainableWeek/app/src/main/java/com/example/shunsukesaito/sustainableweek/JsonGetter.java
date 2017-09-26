package com.example.shunsukesaito.sustainableweek;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saitoushunsuke on 2017/09/26.
 */

public class JsonGetter extends AsyncTaskLoader<JSONObject> {
    private String urlText;

    public JsonGetter(Context context, String urlText){
        super(context);
        this.urlText = urlText;
    }

    @Override
    public JSONObject loadInBackground() {
        HttpURLConnection connection = null;

        try{
            URL url = new URL(urlText);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
        }
        catch (MalformedURLException exception){
            // 処理なし
        }
        catch (IOException exception){
            // 処理なし
        }

        try{
            BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1){
                if (length > 0){
                    outputStream.write(buffer, 0, length);
                }
            }

            JSONObject json = new JSONObject(new String(outputStream.toByteArray()));
            return json;
        }
        catch (IOException exception){
            // 処理なし
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
