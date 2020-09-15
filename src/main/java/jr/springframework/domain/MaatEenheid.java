package jr.springframework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class MaatEenheid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eenheid;

    @OneToMany(mappedBy = "maatEenheid")
    private List<Ingredient> ingredienten = new ArrayList<>();

    public MaatEenheid() {}

    public MaatEenheid(String eenheid) {
        this.eenheid = eenheid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEenheid() {
        return eenheid;
    }

    public void setEenheid(String eenheid) {
        this.eenheid = eenheid;
    }

    public List<Ingredient> getIngredienten() {
        return Collections.unmodifiableList(this.ingredienten);
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredienten.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredienten.remove(ingredient);
    }
}
