package com.example.tp1958;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.calculerImc);
        Button raz = findViewById(R.id.raz);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView error = findViewById(R.id.error);
                error.setText("");
                EditText poids = findViewById(R.id.poidsEditText);
                EditText taille = findViewById(R.id.tailleEditText);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                RadioButton metre = findViewById(R.id.metreButton);
                RadioButton centimetre = findViewById(R.id.centimetreButton);

                TextView result = findViewById(R.id.result);


                double tailleValue=0;
                String finalResult = "";

                if (radioGroup.getCheckedRadioButtonId() == R.id.metreButton ) {
                    try {
                        tailleValue = Double.parseDouble(taille.getText().toString());
                    }catch (Exception e){
                        error.setText("Veuillez remplir tous les champs requis !");

                    }
                }
                else {

                    try {
                        tailleValue = Double.parseDouble(taille.getText().toString())/100;
                    }catch (Exception e){
                        error.setText("Veuillez remplir tous les champs requis !");

                    }
                }

                try {
                    DecimalFormat df = new DecimalFormat("#.##");
                    finalResult = df.format(Double.parseDouble(String.valueOf(Double.parseDouble(poids.getText().toString()) / Math.pow(tailleValue,2))));
                }catch (Exception e){
                    error.setText("Veuillez remplir tous les champs requis !");

                }



                result.setText(finalResult);


            }
        });

        raz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText poids = findViewById(R.id.poidsEditText);
                EditText taille = findViewById(R.id.tailleEditText);
                poids.setText("");
                taille.setText("");

            }
        });

    }
}