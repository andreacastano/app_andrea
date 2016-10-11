package com.yolimaandrea.app_andrea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {

    EditText eUser, ePassword;
    Button bLogin;
    TextView tRegister;

    private String name="", password="", email="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);


        eUser = (EditText) findViewById(R.id.eUser);
        ePassword = (EditText) findViewById(R.id.ePassword);
        bLogin = (Button) findViewById(R.id.bEntrar);
        tRegister = (TextView) findViewById(R.id.tRegistro);

        tRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LogginActivity.this, RegistroActivity.class);
                startActivityForResult(myIntent,1234);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, contrasena;
                nombre = eUser.getText().toString();
                contrasena = ePassword.getText().toString();
                if ((nombre.equals("") || contrasena.equals(""))){
                    Toast.makeText(getApplicationContext(), "Campos en blanco", Toast.LENGTH_SHORT).show();
                } else {
                    if ((name.equals(nombre) && password.equals(contrasena))){
                        Intent intent = new Intent(LogginActivity.this, MainActivity.class);
                        intent.putExtra("nombre",name);
                        intent.putExtra("email", email);

                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Fail, try again..!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_CANCELED)
            Toast.makeText(this, "Usuario No registrado", Toast.LENGTH_SHORT).show();
        else{
            if (requestCode == 1234 && resultCode == RESULT_CANCELED){
                name = data.getExtras().getString("name");
                password = data.getExtras().getString("password");
                email = data.getExtras().getString("mail");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
