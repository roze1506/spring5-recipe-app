package jr.springframework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String afdelingNaam;

    @ManyToMany(mappedBy = "categorieen")
    private List<Recept> recepten = new ArrayList<>();

    public Categorie() {}

    public Categorie(String afdelingNaam) {
        this.afdelingNaam = afdelingNaam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAfdelingNaam() {
        return afdelingNaam;
    }

    public void setAfdelingNaam(String afdelingNaam) {
        this.afdelingNaam = afdelingNaam;
    }

    public List<Recept> getRecepten() {
        return Collections.unmodifiableList(this.recepten);
    }

    public void addRecept(Recept recept) {
        this.recepten.add(recept);
    }

    public void removeRecept(Recept recept) {
        this.recepten.remove(recept);
    }
}
