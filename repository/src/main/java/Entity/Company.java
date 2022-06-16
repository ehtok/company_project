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
@Table(name = "company")
@Entity
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "company_size")
    private String companySize;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "company_description")
    private String description;

    @OneToMany(mappedBy = "company")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Vacancy> vacancies = new HashSet<>();

    @Override
    public String toString() {
        return "Company " +
                "id = " + id +
                ", name = " + name +
                ", companySize = " + companySize +
                ", companyType = " + companyType +
                ", description = " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id.equals(company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
