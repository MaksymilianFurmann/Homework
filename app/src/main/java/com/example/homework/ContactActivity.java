package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        String[] array = new String[]{"Monika", "Paulina", "Sandra", "Weronika"};
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        set();
    }


    public void set() {
        final Button cancel = (Button) findViewById(R.id.cancelButton2);
        final Button ok = (Button) findViewById(R.id.okButton2);

        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.cancelButton2:
                        onBackPressed();
                        break;
                    case R.id.okButton2:
                        Spinner Spinner = (Spinner) findViewById(R.id.spinner);
                        String name = Spinner.getSelectedItem().toString();
                        Intent resultData = new Intent();
                        resultData.putExtra("ContactName", name);
                        setResult(Activity.RESULT_OK, resultData);
                        finish();
                        break;
                }
            }


        };

        cancel.setOnClickListener(myClickListener);
        ok.setOnClickListener(myClickListener);
    }
}
