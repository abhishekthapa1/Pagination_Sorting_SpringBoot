package paginationandsorting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_countries_country_name", columnNames = "country_name")})
public class Countries {
    @Id
    @SequenceGenerator(name = "countries_seq_gen", sequenceName = "countries_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_seq_gen")
    private Long id;

    @Column(name = "country_name", length = 80, nullable = false)
    private String countryName;

    @Column(name = "country_population", nullable = false)
    private Long countryPopulation;

}
