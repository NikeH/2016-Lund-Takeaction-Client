package org.actionaid.actnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        retrieve.execute();
        lv = (ListView) findViewById(R.id.articleList);

        ArrayList<String> articles = new ArrayList<String>();
        articles.add("asdf");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");
        articles.add("ghjk");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                articles );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                openTakeAction(lv);
            }
        });
    }


/*        final RelativeLayout topRelativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        final TextView topicTest = new TextView(this);
        topicTest.setText("2/12 Demonstration for civil rights");
        topicTest.setGravity(Gravity.LEFT);
        topRelativeLayout.addView(topicTest);
        RelativeLayout.LayoutParams textviewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textviewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        topicTest.setLayoutParams(textviewParams);

        final Button actNow = new Button(this);
        actNow.setText("Act now!");
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        actNow.setLayoutParams(buttonParams);
        actNow.setGravity(Gravity.RIGHT);
        actNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TakeAction.class);
                startActivity(i);
            }

        });
        topRelativeLayout.addView(actNow);*/


    public void openSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        Log.i("INFO", data);
    }

    public void fillData(String data) {
        this.data = data;
    }

    public void openTakeAction(View view){
        Intent intent = new Intent(this, TakeAction.class);
        startActivity(intent);
    }
}
