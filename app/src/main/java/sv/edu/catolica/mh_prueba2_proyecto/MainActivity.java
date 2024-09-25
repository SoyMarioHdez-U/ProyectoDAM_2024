package sv.edu.catolica.mh_prueba2_proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView TvRegistrarse;
    private EditText etUsuario, etPassword;
    private Button btnEntrar;

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

        btnEntrar = findViewById(R.id.btnEntrar);
        etUsuario = findViewById(R.id.et_usuario);
        etPassword = findViewById(R.id.et_password);
        TvRegistrarse = findViewById(R.id.tv_registrarse);
        TvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent Login = new Intent(MainActivity.this, Registrarse.class);

                startActivityForResult(Login, 1234);
            }


        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                // Verificación de credenciales
                if (usuario.equals("usuario") && password.equals("12345678")) {
                    // Credenciales correctas, abrir HomeActivity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Opcional, para cerrar la pantalla de login
                } else {
                    // Credenciales incorrectas, mostrar mensaje de error
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void AbrirRegistrarse(View v){
        Intent registrarse = new Intent(MainActivity.this, Registrarse.class);
        startActivity(registrarse);
    }
}