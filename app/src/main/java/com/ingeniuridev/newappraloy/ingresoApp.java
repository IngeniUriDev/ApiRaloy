package com.ingeniuridev.newappraloy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ingresoApp extends AppCompatActivity {
    private EditText username, passApp;

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

        username = findViewById(R.id.username);
        passApp = findViewById(R.id.passApp);
    }
    public void ingresoApp1(View v){
        String usuario = username.getText().toString();
        String contraseña = passApp.getText().toString();

        if (ValidacionUsser(usuario,contraseña)){
            Toast.makeText(this, "Bienvenido  " + usuario, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, window1.class);
            startActivity(intent);}
        else if (contraseña.isEmpty() && usuario.isEmpty()){
            Toast.makeText(this, "Por favor ingresa usuario y contraseña", Toast.LENGTH_SHORT).show();
        }else if (contraseña.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa una contraseña", Toast.LENGTH_SHORT).show();
        }else if(usuario.isEmpty()){
            Toast.makeText(this, "Por favor ingresa un usuario", Toast.LENGTH_SHORT).show();
        }else if (!usuario.equals("admin")){
            Toast.makeText(this, "Ingresa un usuario valido", Toast.LENGTH_SHORT).show();
        }else if(!contraseña.equals("admin123")){
            Toast.makeText(this, "Contraseña invalida", Toast.LENGTH_SHORT).show();
        }
    }
    public void registroApp(View v){
        /*Aqui conectaremos el boton con un formulario para registro de usuarios*/

    }

    private boolean ValidacionUsser(String username, String passApp){
        return username.equals("admin") && passApp.equals("admin123");

    }
}