package com.example.wordcounterapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wordcounterapp.java.CountingLogic;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Spinner spCountOptions;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.edUserInput = findViewById(R.id.UserInput);
        this.spCountOptions = findViewById(R.id.spCountOptions);
        this.tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.CountOptions,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//applying the adapter to the spinner.
        spCountOptions.setAdapter(adapter);
    }
     //method button click event
        public void onBthCountLink(View view){
        //get user input
            String UserInput = this.edUserInput.getText().toString();

            //check if input is empty
            if (UserInput.isEmpty()) {
                Toast.makeText(this, "Enter text or characters", Toast.LENGTH_SHORT).show();
                return;
            }

            //selected option from the Spinner
            String selectedOption = spCountOptions.getSelectedItem().toString();

            //user input as a String
            String userInput = edUserInput.getText().toString().trim();


            //CountingLogic instance
            //CountingLogic tc = new CountingLogic();

            //count result
            int countResult;

            //check
            if (selectedOption.equals("Words")) {
                //words
                countResult = CountingLogic.getWordCount(userInput);
            } else {
                //characters
                countResult = CountingLogic.getCharsCount(userInput);
            }

            //result in the TextView
            tvResult.setText(String.valueOf(countResult));
        }
    }
