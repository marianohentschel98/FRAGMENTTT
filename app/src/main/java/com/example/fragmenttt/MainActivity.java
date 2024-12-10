package com.example.fragmenttt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button buttonActualizar;
    private FragmentManager fragmentManager;
    private Mifragment mifragment;

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

        editText = findViewById(R.id.editText);
        buttonActualizar = findViewById(R.id.buttonCreateFragment);

        fragmentManager = getSupportFragmentManager();

        mifragment = (Mifragment) fragmentManager.findFragmentByTag("Mifragment");

        if (mifragment == null) {
            mifragment = new Mifragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, mifragment, "Mifragment")
                    .commit();
        }

        buttonActualizar.setOnClickListener(v -> {
            String texto = editText.getText().toString();
            mifragment.actualizarTexto(texto);
        });
    }
}