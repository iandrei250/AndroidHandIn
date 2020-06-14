package com.example.handinapp.View;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.handinapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button signUp;
    private TextView goToLogin;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        signUp = findViewById(R.id.Sign_Up);
        goToLogin = findViewById(R.id.go_to_login);
        mFirebaseAuth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String emailInput = email.getText().toString();
                String passwordInput = email.getText().toString();

                if(emailInput.isEmpty())
                {
                    email.setError("Email field cannot be empty!");
                    email.requestFocus();
                }
                else if(passwordInput.isEmpty())
                {
                    password.setError("Password field cannot be empty!");
                    password.requestFocus();
                }
                else  if(emailInput.isEmpty() && passwordInput.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }

                else  if(!(emailInput.isEmpty() && passwordInput.isEmpty())) {
                  mFirebaseAuth.createUserWithEmailAndPassword(emailInput, passwordInput).addOnCompleteListener(
                          RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  if(!task.isSuccessful())
                                  {
                                      System.out.println(task.getException().getMessage());
                                      Toast.makeText(RegisterActivity.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT).show();
                                  }
                                  else
                                  {

                                      Intent intToHome = new Intent(RegisterActivity.this,MainActivity.class);
                                      startActivity(intToHome);
                                  }
                              }
                          });
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
