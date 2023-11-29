package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class login_phone_number extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText phoneinput;
    Button sendOtpbtn;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone_number);

        countryCodePicker = findViewById(R.id.login_countrycode);
        phoneinput = findViewById(R.id.login_mobile_number);
        sendOtpbtn =findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);
        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneinput);
        sendOtpbtn.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                phoneinput.setError("phone number not valid");
                return;
            }
            Intent intent = new Intent(login_phone_number.this, LoginOtpActivity.class);

            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });
    }
}