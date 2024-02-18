package cz.daniellinda.trixie.database;

import jakarta.persistence.*;

@Entity
public class Obce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String nazev;
    @Column(unique = true, length = 20, nullable = false)
    private String kod;

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

    @Override
    public String toString() {
        return "Obce{" +
                "id=" + id +
                ", nazev='" + nazev + '\'' +
                ", kod='" + kod + '\'' +
                '}';
    }
}
