package com.inacap.passwordeva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    //private Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //register = findViewById(R.id.loginRegisterBtn);
        //login = findViewById(R.id.loginBtn);

        /*
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(this, Register.class);
                startActivity(i);
            }
        });
        */

    }

    public void goToRegister (View v) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

}