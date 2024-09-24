package sv.edu.catolica.mh_prueba2_proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Registrarse extends AppCompatActivity {

    private TextView TvIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registrarse);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TvIngresar = findViewById(R.id.tv_ingresar);
        TvIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent Login = new Intent(Registrarse.this, MainActivity.class);

                startActivityForResult(Login, 1234);
            }


        });
    }
}