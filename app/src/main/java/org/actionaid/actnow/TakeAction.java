package org.actionaid.actnow;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TakeAction extends AppCompatActivity {
    private String infoTitleText = "What is the problem?";
    private String infoText = "The rich keep getting richer. Sixty-three people own 90% of the world's money. Let's change that. Robin Hood!";
    private String actionTitleText = "What can you do?";
    private String[] actions = new String[]{"Join the demonstration", "Donate", "Tweet"};
    private String actionsText = "- " + actions[0] + "\n- " + actions[1] + "\n- " + actions[2];
    private int padding = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Take Action");
        setContentView(R.layout.activity_take_action);

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_take_action);

        ScrollView scroll = new ScrollView(this);
        scroll.setPadding(padding, padding, padding, padding);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);

        TextView infoTitle = new TextView(this);
        infoTitle.setText(infoTitleText);
        infoTitle.setTextSize(20);
        infoTitle.setTextColor(Color.BLACK);
        //infoTitle.setGravity(View.TEXT_ALIGNMENT_CENTER);

        TextView info = new TextView(this);
        info.setText(infoText + "\n");

        TextView actTitle = new TextView(this);
        actTitle.setText(actionTitleText);
        actTitle.setTextSize(20);
        actTitle.setTextColor(Color.BLACK);

        TextView act = new TextView(this);
        act.setText(actionsText);

        main.addView(infoTitle);
        main.addView(info);
        main.addView(actTitle);
        main.addView(act);


        scroll.addView(main);

        layout.addView(scroll);

    }

    public void goBack(View view){
        finish();
    }
}
