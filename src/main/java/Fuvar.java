package main.java;
public class Fuvar {
    private int taxiId;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesModja;

    public Fuvar(int taxiId, String indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizetesModja) {
        this.taxiId = taxiId;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    // Getters
    public int getTaxiId() { return taxiId; }
    public String getIndulas() { return indulas; }
    public int getIdotartam() { return idotartam; }
    public double getTavolsag() { return tavolsag; }
    public double getViteldij() { return viteldij; }
    public double getBorravalo() { return borravalo; }
    public String getFizetesModja() { return fizetesModja; }

    @Override
    public String toString() {
        return "Fuvar{" +
                "taxiId=" + taxiId +
                ", indulas='" + indulas + '\'' +
                ", idotartam=" + idotartam +
                ", tavolsag=" + tavolsag +
                ", viteldij=" + viteldij +
                ", borravalo=" + borravalo +
                ", fizetesModja='" + fizetesModja + '\'' +
                '}';
    }
}

