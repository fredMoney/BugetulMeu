package ro.ase.pdm.seminar3_bugetulmeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   final int COD_TRANZACTIE=100;

    ListView lvTranzactii;

    List<Tranzactie> listaTranzactii = new ArrayList<>();

    ArrayAdapter<Tranzactie> adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabAdauga = findViewById(R.id.fab_adauga);
        listaTranzactii.add(new Tranzactie(Tip.Venit, Valuta.RON,"salariu",
                new Date(), 500));
        lvTranzactii = findViewById(R.id.lv_tranzactii);
        adaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaTranzactii);

         lvTranzactii.setAdapter(adaptor);
        fabAdauga.setOnClickListener(view -> {
            Intent intent = new Intent(this, AdaugaActivity.class);
            startActivityForResult(intent,COD_TRANZACTIE);
        });
    }
//metoda getView se apeleaza pt fiecare element
    // pt fiecare view existent trebuie sa apelam metodele corespunzatoare
    //tema : proiectam macheta pt elementele din lista
    // sa controlam afisarea la schimbarea configuratiei
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == COD_TRANZACTIE && resultCode== RESULT_OK) {
               if(data != null)
               {
                  Tranzactie tranzactie = (Tranzactie) data.getSerializableExtra("tranzactie");
                  listaTranzactii.add(tranzactie);
                  adaptor.notifyDataSetChanged();
               }
        }

            super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_despre) {
            Intent intent = new Intent(this, DespreActivity.class);
            startActivity(intent);

            return true;
        }

        if(item.getItemId() == R.id.action_adauga) {
            Intent intent = new Intent(this, AdaugaActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
