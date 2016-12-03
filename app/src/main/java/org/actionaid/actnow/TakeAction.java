package org.actionaid.actnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TakeAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Take Action");
        setContentView(R.layout.activity_take_action);
    }

    public void goBack(View view){
        finish();
    }
}
