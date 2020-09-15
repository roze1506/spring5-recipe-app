package jr.springframework.domain;

import javax.persistence.*;

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
}
