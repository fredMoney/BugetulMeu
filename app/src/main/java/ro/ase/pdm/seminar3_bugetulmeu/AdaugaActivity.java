package ro.ase.pdm.seminar3_bugetulmeu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdaugaActivity<AwesomeValidation> extends AppCompatActivity {

    RadioGroup rgValuta;
    RadioButton rbRon, rbEur;
    Spinner spTranzactii;
    EditText etSuma, etDescriere;
    DatePicker dpData;
    Button btnAdauga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga);
        rgValuta = findViewById(R.id.rg_valuta);
        spTranzactii = findViewById(R.id.sp_tranzactie);
        etSuma = findViewById(R.id.et_suma);
        etDescriere = findViewById(R.id.et_descriere);
        dpData = findViewById(R.id.dp_data);
        btnAdauga = findViewById(R.id.btn_adauga);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etSuma.getText().toString().isEmpty())
                    etSuma.setError("Introduceti o suma valida");
                else if (etDescriere.getText().toString().isEmpty())
                    etDescriere.setError("Introduceti o descrirere valida");
                else {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                    try {
                        double suma = Double.parseDouble(etSuma.getText().toString());
                        String descriere = etDescriere.getText().toString();

                        Tranzactie tranzactie = intializeazaTranzactie();
                        Intent intent = new Intent();
                        intent.putExtra("tranzactie",tranzactie);
                        setResult(RESULT_OK,intent);

                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Date invalide",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    };

    private Tranzactie intializeazaTranzactie() {
        Tranzactie tranzactie = new Tranzactie();

        tranzactie.setSuma(Double.parseDouble(etSuma.getText().toString()));
        tranzactie.setDescriere(etDescriere.getText().toString());
        tranzactie.setData(new Date(dpData.getYear(), dpData.getMonth(), dpData.getDayOfMonth()));

        String tipTranz = spTranzactii.getSelectedItem().toString();
        tranzactie.setTip(Tip.valueOf(tipTranz));


        if (rgValuta.getCheckedRadioButtonId() == R.id.rb_eur) {
            tranzactie.setValuta(Valuta.EUR);
        } else {
            tranzactie.setValuta(Valuta.RON);
        }

        return tranzactie;
    }
}