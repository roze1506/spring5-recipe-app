package jr.springframework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String afdelingNaam;

    @ManyToMany(mappedBy = "categorieen")
    private List<Recept> recepten = new ArrayList<>();

    public Categorie(String afdelingNaam) {
        this.afdelingNaam = afdelingNaam;
    }

    public void addRecept(Recept recept) {
        this.recepten.add(recept);
    }

    public void removeRecept(Recept recept) {
        this.recepten.remove(recept);
    }
}
