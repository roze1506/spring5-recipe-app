package jr.springframework.domain;

import jr.springframework.enums.Moeilijkheidsgraad;

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

    public Recept() {}

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

    public Moeilijkheidsgraad getMoeilijkheidsgraad() {
        return moeilijkheidsgraad;
    }

    public void setMoeilijkheidsgraad(Moeilijkheidsgraad moeilijkheidsgraad) {
        this.moeilijkheidsgraad = moeilijkheidsgraad;
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
