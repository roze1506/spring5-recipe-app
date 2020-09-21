package jr.springframework.domain;

import jr.springframework.enums.Moeilijkheidsgraad;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String omschrijving;

    private Integer kookTijd;

    private Integer porties;

    private String bron;

    private String url;

    @Lob
    private String aanwijzingen;

    @Lob
    private Byte[] afbeelding;

    @Enumerated(value = EnumType.STRING)
    private Moeilijkheidsgraad moeilijkheidsgraad;

    @OneToOne(cascade = CascadeType.ALL)
    private Notitie notitie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recept")
    private List<Ingredient> ingredienten = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "recept_categorie",
    joinColumns = @JoinColumn(name = "recept_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categorieen = new ArrayList<>();

    public Recept(String omschrijving, Integer kookTijd, Integer porties, String bron, String url,
                  String aanwijzingen, Moeilijkheidsgraad moeilijkheidsgraad, Notitie notitie) {
        this.omschrijving = omschrijving;
        this.kookTijd = kookTijd;
        this.porties = porties;
        this.bron = bron;
        this.url = url;
        this.aanwijzingen = aanwijzingen;
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        this.notitie = notitie;
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

    public List<Categorie> getCategorieen() {
        return Collections.unmodifiableList(this.categorieen);
    }

    public void addCategorie(Categorie categorie) {
        this.categorieen.add(categorie);
    }

    public void removeCategorie(Categorie categorie) {
        this.categorieen.remove(categorie);
    }
}
