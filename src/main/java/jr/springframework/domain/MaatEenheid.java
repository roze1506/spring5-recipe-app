package jr.springframework.domain;

import javax.persistence.*;

@Entity
public class MaatEenheid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eenheid;

    @OneToOne
    private Ingredient ingredient;
}
