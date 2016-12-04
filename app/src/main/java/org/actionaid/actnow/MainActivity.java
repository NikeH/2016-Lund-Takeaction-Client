package org.actionaid.actnow;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private String data;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Actions");
        setContentView(R.layout.activity_main);
        RetrieveFeedTask retrieve = new RetrieveFeedTask();
        retrieve.setMainActivity(this);
        try {
           data = retrieve.execute().get();
        } catch (Exception e) {

        }

        lv = (ListView) findViewById(R.id.articleList);

        JSONObject obj = new JSONObject();
        try {

            obj = new JSONObject(data);

            Log.d("Main activity", obj.toString());

        } catch (Throwable t) {
            Log.e("Main activity", "Could not parse malformed JSON: \"" + data + "\"");
        }

        ArrayList<ArticleData> articles = new ArrayList<ArticleData>();
        try {
        JSONArray items = obj.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            JSONObject c = items.getJSONObject(i);

            String id = c.getString("id");
            String date = c.getString("date");
            String title = c.getString("title");
            String body = c.getString("body");

            if(date.equals("null")){
                date = "";
            }
            ArticleData ad = new ArticleData(id, date, title, body);

            articles.add(ad);
        }
        } catch (final JSONException e) {
            Log.e("Json parsing error: " , e.getMessage());
            }


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<ArticleData> arrayAdapter = new ListAdapter(
                this,
                android.R.layout.simple_list_item_1,
                articles);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                openTakeAction(lv);
            }
        });
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void fillData(String data) {
        this.data = data;
    }

    public void openTakeAction(View view){
        Intent intent = new Intent(this, TakeAction.class);
        startActivity(intent);
    }
}
