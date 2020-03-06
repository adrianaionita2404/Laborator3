package com.example.phonedialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    public String myNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myFancyMethod(View v) {
        String str = ((Button) v).getText().toString();
        myNumber = myNumber + str;

        EditText nr = (EditText)findViewById(R.id.number);
        nr.setText(myNumber);
        nr.setSelection(nr.getText().length());
    }

    public void deleteLast(View v) {
        if (myNumber.length() > 0)
            myNumber = myNumber.substring(0, myNumber.length() - 1);

        EditText nr = (EditText)findViewById(R.id.number);
        nr.setText(myNumber);
        nr.setSelection(nr.getText().length());
    }

    public void callMe(View v) {
        String uri = "tel:" + myNumber.trim() ;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(uri));
        if (ContextCompat.checkSelfPermission( this, android.Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED ) {
            // Permission is not granted
        }

        startActivity(intent);
    }
}
