package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TECHNOLOGY")
@Entity
public class Technology implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_technology")
    private String name;

    @ManyToMany(mappedBy = "technologies")
    private Set<Vacancy> vacancies = new HashSet<>();


}
