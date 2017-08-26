package com.intrcptr.actionbartest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    TextView detail_text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // using textView in Toolbar in activity_main.xml
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        detail_text_view = (TextView) findViewById(R.id.detail_title);
//        detail_text_view.setText("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");

        TextView titletextview;
        try{
            Field field = Toolbar.class.getDeclaredField( "mTitleTextView" );
            field.setAccessible( true );
            titletextview = (TextView)field.get( toolbar );
            titletextview.setText("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
            titletextview.setSingleLine( false );
            titletextview.setMaxLines( 2 );
            titletextview.setEllipsize( TextUtils.TruncateAt.END );
        }catch( Exception e ) {
            Log.e(MainActivity.class.toString(), "", e );
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}
