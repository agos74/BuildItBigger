package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.displayjoke.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void tellJoke(final View view) {

        spinner.setVisibility(View.VISIBLE);

        new EndpointsAsyncTask(new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(String result) {
                ProgressBar spinner = findViewById(R.id.progressBar);
                spinner.setVisibility(View.GONE);

                if (result != null) { //result is null if there was an error
                    Intent intent = new Intent(view.getContext(), JokeActivity.class);
                    intent.putExtra(JokeActivity.JOKE_KEY, result);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, R.string.connection_error, Toast.LENGTH_LONG).show();
                }

            }
        }).execute();
    }

}
