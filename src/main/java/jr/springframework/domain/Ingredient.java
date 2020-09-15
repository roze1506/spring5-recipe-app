package jr.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String beschrijving;

    private BigDecimal aantal;

    @ManyToOne
    private MaatEenheid maatEenheid;

    @ManyToOne
    private Recept recept;

    public Ingredient() {}

    public Ingredient(String beschrijving, BigDecimal aantal, MaatEenheid maatEenheid, Recept recept) {
        this.beschrijving = beschrijving;
        this.aantal = aantal;
        this.maatEenheid = maatEenheid;
        this.recept = recept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public BigDecimal getAantal() {
        return aantal;
    }

    public void setAantal(BigDecimal aantal) {
        this.aantal = aantal;
    }

    public MaatEenheid getMaatEenheid() {
        return maatEenheid;
    }

    public void setMaatEenheid(MaatEenheid maatEenheid) {
        this.maatEenheid = maatEenheid;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }
}
