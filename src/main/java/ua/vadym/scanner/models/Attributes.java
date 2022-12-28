package ua.vadym.scanner.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "value")
    private double value;

    @Column(name = "raining")
    private boolean raining;

    @Column(name = "nowtime")
    private LocalDate nowTime;

    @OneToOne
    @JoinColumn(name = "scanner_id", referencedColumnName = "id")
    private Scanner scanner;
}
