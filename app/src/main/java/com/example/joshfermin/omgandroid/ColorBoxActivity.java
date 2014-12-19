package com.example.joshfermin.omgandroid;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

//Every Activity is invoked by an Intent, regardless of how the user navigated there.
// You can get the Intent that started your activity by calling getIntent()
// and retrieve the data contained within the intent.

public class ColorBoxActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create the text view


        // Set the text view as the activity layout
//        setContentView(textView);

//        Color mColor = new Color();
//        mColor.red();
//        mColor.green(greenvalue);
//        mColor.blue(bluevalue);

        setContentView(R.layout.colorbox);
        View surface = findViewById(R.id.surface);
        if (message.equals("red")) {
            surface.setBackgroundColor(Color.RED);
        } else if (message.equals("blue")) {
            surface.setBackgroundColor(Color.BLUE);
        } else if (message.equals("green")) {
            surface.setBackgroundColor(Color.GREEN);
        }


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
}
