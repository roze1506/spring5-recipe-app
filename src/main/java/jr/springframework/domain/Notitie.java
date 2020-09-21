package jr.springframework.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Notitie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tekst;

    @OneToOne
    private Recept recept;

    public Notitie(String tekst, Recept recept) {
        this.tekst = tekst;
        this.recept = recept;
    }
}
