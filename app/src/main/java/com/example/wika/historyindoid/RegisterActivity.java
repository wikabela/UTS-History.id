package com.example.wika.historyindoid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wika.historyindoid.database.DBHelper;

public class RegisterActivity extends AppCompatActivity {
    EditText txtUsername;
    EditText txtPassword;
    EditText txtConfPassword;
    Button btnRegister;
    TextView txtLogin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);
        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        txtConfPassword = findViewById(R.id.txt_conf_password);
        btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUsername.getText().toString().trim();
                String pass = txtPassword.getText().toString().trim();
                String conf = txtConfPassword.getText().toString().trim();
                if(pass.equals(conf)){
                    long val = db.addUser(user, pass);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this, "Berhasil register",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registrasi Gagal",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(RegisterActivity.this, "Password yang anda masukkan tidak sama",Toast.LENGTH_SHORT).show();
                }



            }
        });

        txtLogin = findViewById(R.id.txt_login);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
