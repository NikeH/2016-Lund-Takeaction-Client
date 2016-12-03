package org.actionaid.actnow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    CheckBox boxIneq, boxFood, boxWomen, boxDem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        boxIneq = (CheckBox) findViewById(R.id.checkBoxIneq);
        boxFood = (CheckBox) findViewById(R.id.checkBoxFood);
        boxWomen = (CheckBox) findViewById(R.id.checkBoxWomen);
        boxDem = (CheckBox) findViewById(R.id.checkBoxDem);

        boxIneq.setChecked(sharedPref.getBoolean("ineq", false));
        boxFood.setChecked(sharedPref.getBoolean("food", false));
        boxWomen.setChecked(sharedPref.getBoolean("women", false));
        boxDem.setChecked(sharedPref.getBoolean("dem", false));
    }

    public void clickSave(View v) {
        // https://developer.android.com/training/basics/data-storage/shared-preferences.html
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("ineq", boxIneq.isChecked());
        editor.putBoolean("food", boxFood.isChecked());
        editor.putBoolean("women", boxWomen.isChecked());
        editor.putBoolean("dem", boxDem.isChecked());
        editor.commit();

//        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        long highScore = sharedPref.getInt(getString(R.string.saved_high_score), 0);

        Intent intent = new Intent(this, MainActivity.class);
        // Make the back button not go back to the settings menu once you're out of here
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
