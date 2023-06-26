package com.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loginandsignup.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    TextView openSignUp;
    Button    loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openSignUp = findViewById(R.id.openSignUp);
        loginbtn   = findViewById(R.id.login_btn);

        openSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);

            //adding animation
            overridePendingTransition(R.anim.slide_in_right,
                    R.anim.slide_out_left);
            finish();
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

                //adding animation
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
                finish();
            }
        });

    }
}