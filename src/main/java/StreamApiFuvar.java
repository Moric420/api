package main.java;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StreamApiFuvar {
    public static void main(String[] args) throws IOException {
        List<Fuvar> fuvarok = new ArrayList<>();

        Files.lines(Paths.get("fuvar.csv"))
                .skip(1) // Fejléc átugrása
                .forEach(line -> {
                    String[] parts = line.split(";");
                    int taxiId = Integer.parseInt(parts[0]);
                    String indulas = parts[1];
                    int idotartam = Integer.parseInt(parts[2]);
                    double tavolsag = Double.parseDouble(parts[3].replace(',', '.'));
                    double viteldij = Double.parseDouble(parts[4].replace(',', '.'));
                    double borravalo = Double.parseDouble(parts[5].replace(',', '.'));
                    String fizetesModja = parts[6];

                    fuvarok.add(new Fuvar(taxiId, indulas, idotartam, tavolsag, viteldij, borravalo, fizetesModja));
                });

        System.out.println("Adatok beolvasva: " + fuvarok.size() + " fuvar.");

        //1. feladat
        System.out.println("1. feladat: Fuvarok száma: " + fuvarok.size());

        //2. feladat
        var taxi6185 = fuvarok.stream()
                .filter(f -> f.getTaxiId() == 6185)
                .toList();

        double bevetel = taxi6185.stream()
                .mapToDouble(f -> f.getViteldij() + f.getBorravalo())
                .sum();

        System.out.println("2. feladat: 6185-ös taxis bevétele: " + bevetel);
        System.out.println("Fuvarok száma: " + taxi6185.size());


        //3. feladat
        double osszTav = fuvarok.stream()
                .mapToDouble(Fuvar::getTavolsag)
                .sum();

        System.out.println("3. feladat: Összes megtett mérföld: " + osszTav);

        //4. feladat
        Fuvar leghosszabbFuvar = fuvarok.stream()
                .max((f1, f2) -> Integer.compare(f1.getIdotartam(), f2.getIdotartam()))
                .orElse(null);

        System.out.println("4. feladat: Leghosszabb fuvar: " + leghosszabbFuvar);

        //5. feladat
        Fuvar legbokezubb = fuvarok.stream()
                .max((f1, f2) -> Double.compare(f1.getBorravalo() / f1.getViteldij(), f2.getBorravalo() / f2.getViteldij()))
                .orElse(null);

        System.out.println("5. feladat: Legbőkezűbb fuvar: " + legbokezubb);



    }
}

