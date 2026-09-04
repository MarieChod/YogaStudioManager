package cz.majasana;

import java.util.ArrayList;

public class Lekce {

    private String nazev;
    private String cas;
    private int kapacita;
    private ArrayList<String> prihlaseni;

    public Lekce(String nazev, String cas, int kapacita) {
        this.nazev = nazev;
        this.cas = cas;
        this.kapacita = kapacita;
        this.prihlaseni = new ArrayList<>();
    }

    public String getNazev() {
        return nazev;
    }

    public String getCas() {
        return cas;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getPocetVolnychMist() {
        return kapacita - prihlaseni.size();
    }

    public boolean jeVolnoMisto() {
        return prihlaseni.size() < kapacita;
    }

    public boolean pridatRezervaci(String jmeno) {
        if (!jeVolnoMisto()) {
            return false;
        }

        prihlaseni.add(jmeno);
        return true;
    }

    public ArrayList<String> getPrihlaseni() {
        return new ArrayList<>(prihlaseni);
    }

    @Override
    public String toString() {
        return nazev + " (" + cas + ") - volných míst: "
                + getPocetVolnychMist() + "/" + kapacita;
    }
}