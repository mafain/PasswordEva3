package com.inacap.passwordeva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    FirebaseFirestore firestore;
    private EditText username, password;
    //private Button register, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    public void registerUser (View v) {
        username = findViewById(R.id.registerInputUsername);
        password = findViewById(R.id.registerInputPassword);
        //register = findViewById(R.id.registerRegisterBtn);
        //cancel = findViewById(R.id.registerCancelBtn);

        if (checkNoEmptyField (username.getText().toString()) && checkNoEmptyField (password.getText().toString())){
            //Valida que ambos campos tengan contenido

            Map<String, Object> users = new HashMap<>();
            users.put("username",username);
            users.put("password",password);

            firestore = FirebaseFirestore.getInstance();

            firestore.collection("users").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(getApplicationContext(),"Éxito",Toast.LENGTH_LONG).show();

                    //Intent i = new Intent(this, MainActivity.class);
                    //startActivity(i);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),"Falló",Toast.LENGTH_LONG).show();
                }
            });

        }
        else {
            Toast.makeText(getApplicationContext(),"Debe completar los campos",Toast.LENGTH_LONG).show();
        }


    }

    public boolean checkNoEmptyField(String field){
        //Valida que el campo no esté vacío
        try {
            if (field.length()>0) return true;
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    public void goToLogin(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}