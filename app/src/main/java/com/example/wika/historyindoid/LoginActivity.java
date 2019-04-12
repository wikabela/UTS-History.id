package com.example.wika.historyindoid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wika.historyindoid.database.DBHelper;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername;
    EditText txtPassword;
    Button btnLogin, btnLink;
    TextView txtRegister;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);
        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUsername.getText().toString().trim();
                String pass = txtPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pass);
                if(res == true){
                    Toast.makeText(LoginActivity.this, "Berhasil Login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, BerandaActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Login Gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtRegister = findViewById(R.id.txt_register);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLink = findViewById(R.id.button_link);
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri instagram = Uri.parse("https://www.instagram.com/historiadotid/");
                Intent intent = new Intent(Intent.ACTION_VIEW, instagram);
                startActivity(intent);
            }
        });
    }
}
