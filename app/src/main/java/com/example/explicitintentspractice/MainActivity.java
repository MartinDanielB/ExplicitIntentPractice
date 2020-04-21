package com.example.explicitintentspractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnAct2, btnAct3;
    EditText nameText;
    final int ACTIVITY3 = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        tvResult = findViewById(R.id.tvResult);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all field!", Toast.LENGTH_SHORT).show();
                }else{
                    String name = nameText.getText().toString().trim();

                    //Starts new activity pointing from main to the next activity
                    Intent intent = new Intent(MainActivity.this,
                            com.example.explicitintentspractice.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,
                        com.example.explicitintentspractice.Activity3.class);

                startActivityForResult(intent, ACTIVITY3);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY3){

            if (resultCode == RESULT_OK){
                tvResult.setText(data.getStringExtra("surname"));
            }else{
                tvResult.setText("No result was found!");
            }
        }
    }
}
