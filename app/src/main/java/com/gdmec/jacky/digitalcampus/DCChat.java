package com.gdmec.jacky.digitalcampus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ListView;

public class DCChat extends AppCompatActivity {
    ListView listview_dcchat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcchat);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        listview_dcchat= (ListView) findViewById(R.id.listview_dcchat);
    }
}
