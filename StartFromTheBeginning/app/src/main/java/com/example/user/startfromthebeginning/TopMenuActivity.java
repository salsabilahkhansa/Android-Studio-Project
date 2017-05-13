package com.example.user.startfromthebeginning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class TopMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pick an Ice Cream");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //bila menekan tombol back maka akan kembali ke home atau MainActiivity
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
