package com.example.explicitintentspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText tvSurname;
    Button btnSubmit,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        tvSurname = findViewById(R.id.tvSurname);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tvSurname.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, "Please enter all Info!", Toast.LENGTH_SHORT).show();
                }else {

                    String surname = tvSurname.getText().toString().trim();

                    Intent intent = new Intent();

                    intent.putExtra("surname", surname);

                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });

    }
}