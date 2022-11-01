package ro.ase.pdm.seminar3_bugetulmeu;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptorTranzactie extends ArrayAdapter<Tranzactie> {
    AdaptorTranzactie(@NonNull Context context, List<Tranzactie> listaTranzactii) {
        super(context, R.layout.elem_lista, listaTranzactii);
    }



}
