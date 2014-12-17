package com.example.joshfermin.omgandroid;

import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.view.MenuInflater;

import java.net.URI;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openSearch() {
        //Do something here.
        Uri uri = Uri.parse("http://www.google.com/#q=fish");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openSettings() {
        //Do something here.
        startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
    }

    public void search(View view){
        EditText editText = (EditText) findViewById(R.id.edit_message); // findViewByID gets the EditText element
        String message = editText.getText().toString(); // assign the editText (enter a message) to local var message
        String googleSearch = "http://www.google.com/#q=";
        String finalstr = googleSearch + message;
        Uri uri = Uri.parse(finalstr);
//        intent.putExtra(EXTRA_MESSAGE, message); // intent carries datatypes as key value pairs called extras (putExtra(key,value))
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent); // starts intent
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class); // this is a reference to the current object — the object whose method or constructor is being called.
        // intent is passed to the class
        EditText editText = (EditText) findViewById(R.id.edit_message); // findViewByID gets the EditText element
        String message = editText.getText().toString(); // assign the editText (enter a message) to local var message
        intent.putExtra(EXTRA_MESSAGE, message); // intent carries datatypes as key value pairs called extras (putExtra(key,value))
        startActivity(intent); // starts intent
    }

    public void generateBox(View view){
        Intent intent = new Intent(this, ColorBoxActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message); // findViewByID gets the EditText element
        String message = editText.getText().toString(); // assign the editText (enter a message) to local var message
        intent.putExtra(EXTRA_MESSAGE, message); // intent carries datatypes as key value pairs called extras (putExtra(key,value))
        startActivity(intent);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
