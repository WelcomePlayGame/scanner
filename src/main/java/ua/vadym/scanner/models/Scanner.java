package ua.vadym.scanner.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Scanner")
public class Scanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "scanner")
    @Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.REFRESH})
    private Attributes attributes;
}
