package ro.ase.pdm.seminar3_bugetulmeu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DespreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despre);

        Button okButton = findViewById(R.id.button_ok);
        okButton.setOnClickListener(view -> {
            finish();
        });
    }
}