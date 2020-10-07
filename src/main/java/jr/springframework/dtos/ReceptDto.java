package jr.springframework.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ReceptDto {

    private Long id;

    private String omschrijving;

    private Integer kookTijd;

    private Integer porties;

    private String bron;

    private String url;

    private String moeilijkheidsgraad;

    private String aanwijzingen;

    private NotitieDto notitie;

    private List<IngredientDto> ingredienten = new ArrayList<>();

    private List<CategorieDto> categorieen = new ArrayList<>();

    public List<IngredientDto> getIngredienten() {
        return Collections.unmodifiableList(ingredienten);
    }

    public void addIngredient(IngredientDto ingredientDto) {
        ingredienten.add(ingredientDto);
    }

    public List<CategorieDto> getCategorieen() {
        return Collections.unmodifiableList(categorieen);
    }

    public void addCategorie(CategorieDto categorieDto) {
        categorieen.add(categorieDto);
    }
}
