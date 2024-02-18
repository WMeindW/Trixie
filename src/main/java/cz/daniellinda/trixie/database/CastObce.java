package cz.daniellinda.trixie.database;

import jakarta.persistence.*;

@Entity
public class CastObce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String nazev;
    @Column(unique = true, length = 20, nullable = false)
    private String kod;
    @Column(length = 20, nullable = false)
    private String kodObce;

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getKodObce() {
        return kodObce;
    }

    public void setKodObce(String kodObce) {
        this.kodObce = kodObce;
    }
}
