package com.example.android.sunshine;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (TextView) findViewById(R.id.textView);
textView.setText(getIntent().getStringExtra("name"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.share, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ( id == R.id.Share){
            Log.d(TAG, "onOptionsItemSelected: Accessed");
            onclickshare();
            Log.d(TAG, "onOptionsItemSelected: ");
            return true;
        }
        if (id == R.id.settings) {
            Intent startSettingsActivity = new Intent(this, SettingsActivity.class);
            startActivity(startSettingsActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void onclickshare(){
        Log.d(TAG, "onclickshare: accessed");
        String mtype = "text/plain";
        String title = "Share weather details";
        String textToShare =  getIntent().getStringExtra("name");
        ShareCompat.IntentBuilder.from(this).setChooserTitle(title).setType(mtype).setText(textToShare).startChooser();
    }
}
