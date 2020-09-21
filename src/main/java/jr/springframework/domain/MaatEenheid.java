package jr.springframework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class MaatEenheid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eenheid;

    @OneToMany(mappedBy = "maatEenheid")
    private List<Ingredient> ingredienten = new ArrayList<>();

    public MaatEenheid(String eenheid) {
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
