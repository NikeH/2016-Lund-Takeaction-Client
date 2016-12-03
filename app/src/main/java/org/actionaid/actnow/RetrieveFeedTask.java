package org.actionaid.actnow;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

    private Exception exception;
    private MainActivity activity;


    protected void onPreExecute() {
        //progressBar.setVisibility(View.VISIBLE);
        //responseView.setText("");
    }

    protected String doInBackground(Void... urls) {


        try {
            URL url = new URL("https://action-aid.herokuapp.com/api/v1/articles.json?cause=global%20warming;location=27.234,57.708");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }

        //Log.i("INFO", response);
        activity.fillData(response);
    }

    public void setMainActivity(MainActivity activity){
        this.activity = activity;
    }
}