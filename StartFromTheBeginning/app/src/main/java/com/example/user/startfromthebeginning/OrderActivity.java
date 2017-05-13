package com.example.user.startfromthebeginning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class OrderActivity extends AppCompatActivity {
    EditText mTextNama;
    TextView mTextHarga, mTextQty;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    String item = null;
    Context mContext;
    Spinner mSpinnerFlavors, mSpinnerTopping;
    List<String> mListFlavors = new ArrayList<>();
    List<String> mListTopping = new ArrayList<>();//membuat array list
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pick an Ice Cream");
        mContext = getApplicationContext();
        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextQty = (TextView) findViewById(R.id.mTextQty);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonMin);
        // spinner
        mSpinnerFlavors = (Spinner) findViewById(R.id.mSpinnerFlavors);
        mListFlavors.add("Gooey Butter Cake");
        mListFlavors.add("Churro");
        mListFlavors.add("Cookies in Cream");
        mListFlavors.add("Drkest Chocolate");//memasukan info ke spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListFlavors);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerFlavors.setAdapter(dataAdapter);
        //spinner2
        mSpinnerTopping = (Spinner) findViewById(R.id.mSpinnerTopping);
        mListTopping.add("Chocolate Syrup");
        mListTopping.add("Oreo");
        mListTopping.add("Rainbow Sprinkles");
        mListTopping.add("M&M's");//memasukan info ke spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListTopping);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerTopping.setAdapter(dataAdapter1);
    }

    public void onClickOrder(View view) {


        String to = "salsabilahkhansa@ymail.com";
        String subject = mTextNama.getText().toString();
        String message = "Saya pesan "
                + mSpinnerFlavors.getSelectedItem()
                + " dengan topping "
                + mSpinnerTopping.getSelectedItem()
                + " sebanyak "
                + mTextQty.getText()
                + " buah, seharga "
                + mTextHarga.getText();

        Intent email = new Intent(Intent.ACTION_SEND); //order email
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Kirim email dengan"));
    }

    public void onClickPlus(View view) {
        harga = harga + 25000; //logic tombol >
        qty = qty + 1;
        mTextQty.setText(qty + "");
        mTextHarga.setText("Rp. " + harga);
    }

    public void onClickMin(View view) { //logic button <
        if (harga != 0) {
            harga = harga - 25000;
            qty = qty - 1;
            mTextQty.setText(qty + "");
            mTextHarga.setText("Rp. " + harga);
        } else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty + "");
            mTextHarga.setText("Rp. " + harga);
        }
    }

    public void onClickReset(View v) {
        harga = 0; //logic reset button
        qty = 0;
        mTextNama.setText("");
        mTextHarga.setText("Rp. " + harga);
        mTextQty.setText(qty + "");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
}




