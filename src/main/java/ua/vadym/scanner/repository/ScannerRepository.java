package ua.vadym.scanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.vadym.scanner.models.Scanner;

@Repository
public interface ScannerRepository extends JpaRepository<Scanner, Long> {

}
