package ro.ase.pdm.seminar3_bugetulmeu;

import java.io.Serializable;
import java.util.Date;

public class Tranzactie implements Serializable {
    private double suma;
    private Date data = new Date();
    private String descriere;
    private Tip tip;
    private Valuta valuta;

    public Tranzactie() {
    }

    public Tranzactie(Tip tip, Valuta valuta, String descriere, Date data,double suma) {
        this.suma = suma;
        this.data = data;
        this.descriere = descriere;
        this.tip = tip;
        this.valuta = valuta;
    }




    public double getSuma() {
        return suma;
    }

    public Date getData() {
        return data;
    }

    public String getDescriere() {
        return descriere;
    }

    public Tip getTip() {
        return tip;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "suma=" + suma +
                ", data=" + data +
                ", descriere='" + descriere + '\'' +
                ", tip=" + tip +
                ", valuta=" + valuta +
                '}';
    }
}