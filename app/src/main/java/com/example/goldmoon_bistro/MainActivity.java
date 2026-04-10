package com.example.goldmoon_bistro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Creación de Variables
    EditText edtusuario, edtclave;
    Button btningresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        edtusuario = findViewById(R.id.edtUsuario);
        edtclave = findViewById(R.id.edtClave);
        btningresar = findViewById(R.id.btnIngresar);

        //Acciones Botón
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos valores ingresados por el usuario
                String usuario = edtusuario.getText().toString().trim();
                String clave = edtclave.getText().toString().trim();

                //Validación campos vacíos
                if(usuario.isEmpty() || clave.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Complete los campos", Toast.LENGTH_SHORT).show();
                }
                //Validación Campos incorrectos
                else if (!usuario.equals("LilianaVillalta") || !clave.equals("goldmoon123")) {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos" , Toast.LENGTH_SHORT).show();
                }
                //Credenciales correctas
                else{
                    Toast.makeText(getApplicationContext(), "Bienvenid@ " +usuario , Toast.LENGTH_SHORT).show();

                    //Navegación hacia activity de Registro, enviado el usuario
                    Intent intent = new Intent(MainActivity.this, Registro.class);
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                }
            }
        });


    }
}