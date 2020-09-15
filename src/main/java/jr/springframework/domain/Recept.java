package jr.springframework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String omschrijving;

    private Integer kookTijd;

    private Integer porties;

    private String bron;

    private String url;

    private String aanwijzingen;

    @Lob
    private Byte[] afbeelding;

    @OneToOne(cascade = CascadeType.ALL)
    private Notitie notitie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recept")
    private List<Ingredient> ingredienten = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Integer getKookTijd() {
        return kookTijd;
    }

    public void setKookTijd(Integer kookTijd) {
        this.kookTijd = kookTijd;
    }

    public Integer getPorties() {
        return porties;
    }

    public void setPorties(Integer porties) {
        this.porties = porties;
    }

    public String getBron() {
        return bron;
    }

    public void setBron(String bron) {
        this.bron = bron;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAanwijzingen() {
        return aanwijzingen;
    }

    public void setAanwijzingen(String aanwijzingen) {
        this.aanwijzingen = aanwijzingen;
    }

    public Byte[] getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(Byte[] afbeelding) {
        this.afbeelding = afbeelding;
    }

    public Notitie getNotitie() {
        return notitie;
    }

    public void setNotitie(Notitie notitie) {
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
}
