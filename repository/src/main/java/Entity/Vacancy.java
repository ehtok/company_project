package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "VACANCY")
@Entity
public class Vacancy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vacancy_name")
    private String name;

    @Column(name = "working_time")
    private String workingTime;

    @Column(name = "experience")
    private String experience;

    @Column(name = "vacancy_location")
    private String location;

    @Column(name = "english_level")
    private String englishLevel;

    @Column(name = "profession_level")
    private String professionLevel;

    @Column(name = "salary")
    private String salary;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "technology_vacancy",
            joinColumns = {@JoinColumn(name = "id_vacancy")},
            inverseJoinColumns = {@JoinColumn(name = "id_technology")})
    private Set<Technology> technologies = new HashSet<>();


    @Override
    public String toString() {
        return "Vacancy " +
                "id = " + id +
                ", name = " + name +
                ", workingTime = " + workingTime +
                ", experience = " + experience +
                ", location = " + location +
                ", englishLevel = " + englishLevel +
                ", professionLevel = " + professionLevel +
                ", salary = " + salary +
                ", status = " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return id.equals(vacancy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
