package com.example.joshfermin.omgandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;






public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class); // this is a reference to the current object — the object whose method or constructor is being called.
                                                                        // intent is passed to the class
        EditText editText = (EditText) findViewById(R.id.edit_message); // findViewByID gets the EditText element
        String message = editText.getText().toString(); // assign the editText (enter a message) to local var message
        intent.putExtra(EXTRA_MESSAGE, message); // intent carries datatypes as key value pairs called extras (putExtra(key,value))
        startActivity(intent); // starts intent
    }
}
