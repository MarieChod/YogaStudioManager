package cz.majasana;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Lekce> lekce = new ArrayList<>();

        lekce.add(new Lekce("Ranní jóga", "8:00", 10));
        lekce.add(new Lekce("Power jóga", "17:00", 8));
        lekce.add(new Lekce("Jóga pro začátečníky", "19:00", 12));

        boolean konec = false;

        while (!konec) {
            System.out.println();
            System.out.println("=== Rezervační systém jógového studia ===");
            System.out.println("1 - Zobrazit lekce");
            System.out.println("2 - Rezervovat lekci");
            System.out.println("3 - Zobrazit přihlášené na lekci");
            System.out.println("4 - Konec");
            System.out.print("Vyber možnost: ");

            String volba = scanner.nextLine();

            switch (volba) {
                case "1":
                    zobrazLekce(lekce);
                    break;

                case "2":
                    rezervujLekci(lekce, scanner);
                    break;

                case "3":
                    zobrazPrihlasene(lekce, scanner);
                    break;

                case "4":
                    konec = true;
                    System.out.println("Nashledanou na matě!");
                    break;

                default:
                    System.out.println("Neplatná volba, zkus to znovu.");
            }
        }

        scanner.close();
    }

    private static void zobrazLekce(ArrayList<Lekce> lekce) {
        System.out.println();

        for (int i = 0; i < lekce.size(); i++) {
            System.out.println((i + 1) + ". " + lekce.get(i));
        }
    }

    private static void rezervujLekci(ArrayList<Lekce> lekce, Scanner scanner) {

        zobrazLekce(lekce);

        System.out.print("Zadej číslo lekce, kterou chceš rezervovat: ");
        int cislo = Integer.parseInt(scanner.nextLine());

        if (cislo < 1 || cislo > lekce.size()) {
            System.out.println("Taková lekce neexistuje.");
            return;
        }

        Lekce vybranaLekce = lekce.get(cislo - 1);

        System.out.print("Zadej své jméno: ");
        String jmeno = scanner.nextLine();

        boolean uspech = vybranaLekce.pridatRezervaci(jmeno);

        if (uspech) {
            System.out.println("Rezervace proběhla úspěšně!");
        } else {
            System.out.println("Bohužel, lekce je plně obsazená.");
        }
    }

    private static void zobrazPrihlasene(ArrayList<Lekce> lekce, Scanner scanner) {

        zobrazLekce(lekce);

        System.out.print("Zadej číslo lekce: ");
        int cislo = Integer.parseInt(scanner.nextLine());

        if (cislo < 1 || cislo > lekce.size()) {
            System.out.println("Taková lekce neexistuje.");
            return;
        }

        Lekce vybranaLekce = lekce.get(cislo - 1);
        ArrayList<String> prihlaseni = vybranaLekce.getPrihlaseni();

        if (prihlaseni.isEmpty()) {
            System.out.println("Zatím nikdo přihlášený.");
            return;
        }

        System.out.println("Přihlášení na lekci " + vybranaLekce.getNazev() + ":");

        for (String jmeno : prihlaseni) {
            System.out.println("- " + jmeno);
        }
    }
}