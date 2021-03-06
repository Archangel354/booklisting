package com.example.owner.booklisting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // The URL for the books
    public static final String BEGINNING_OF_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    public static final String END_OF_URL = "&maxResults=4";
    public static String urlString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the search string from the EditText when the Search button is clicked
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build the complete URL string which will include the search string
                urlString = buildURLString(BEGINNING_OF_URL, END_OF_URL);
                Log.i("LOG","Inside onClickListener " + urlString);

                Intent mIntent = new Intent(MainActivity.this, BookListActivity.class);
                mIntent.putExtra("urlString", urlString);
                startActivity(mIntent);
            }
        });
    }


    public String buildURLString(String beginningURL, String endURL){
        String searchString = "";
        EditText edtSearchString = (EditText) findViewById(R.id.edtSearchString);
        searchString = edtSearchString.getText().toString();

        String URLstring = beginningURL + searchString + endURL;
        return  URLstring;
    }
}
