package com.hienqp.randomnumberexc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textViewTittle;
    EditText editTextMinNumber;
    EditText editTextMaxNumber;
    Button buttonGenerate;
    TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declare();

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String min = editTextMinNumber.getText().toString().trim();
                String max = editTextMaxNumber.getText().toString().trim();

                if (min.isEmpty() || max.isEmpty()) {
                    if (min.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please input min number", Toast.LENGTH_LONG).show();
                    }
                    if (max.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please input max number", Toast.LENGTH_LONG).show();
                    }
                } else {
                    int minNumber = Integer.parseInt(min);
                    int maxNumber = Integer.parseInt(max);

                    if (maxNumber <= minNumber) {
                        Toast.makeText(MainActivity.this, "Ordering is fail !!!", Toast.LENGTH_LONG).show();
                    } else {
                        Random random = new Random();
                        int generatedNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

                        textViewResult.setText(String.valueOf(generatedNumber));
                    }
                }
            }
        });

    }

    private void declare() {
        textViewTittle = (TextView) findViewById(R.id.textview_tittle);
        editTextMinNumber = (EditText) findViewById(R.id.edittext_min);
        editTextMaxNumber = (EditText) findViewById(R.id.edittext_max);
        buttonGenerate = (Button) findViewById(R.id.button_generate);
        textViewResult = (TextView) findViewById(R.id.textview_result);
    }
}