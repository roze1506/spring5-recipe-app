package jr.springframework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
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

    public Ingredient(String beschrijving, BigDecimal aantal, MaatEenheid maatEenheid, Recept recept) {
        this.beschrijving = beschrijving;
        this.aantal = aantal;
        this.maatEenheid = maatEenheid;
        this.recept = recept;
    }
}
