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

    public void vypisInfo() {
        int volnaMista = kapacita - prihlaseni.size();
        System.out.println(nazev + " (" + cas + ") - volných míst: " + volnaMista + "/" + kapacita);
    }

    public void vypisPrihlasene() {
        if (prihlaseni.isEmpty()) {
            System.out.println("Zatím nikdo přihlášený.");
            return;
        }
        System.out.println("Přihlášení na lekci " + nazev + ":");
        for (String jmeno : prihlaseni) {
            System.out.println("- " + jmeno);
        }
    }
}