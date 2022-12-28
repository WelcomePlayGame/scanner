package ua.vadym.scanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.vadym.scanner.models.Attributes;

@Repository
public interface AttributesRepository  extends JpaRepository<Attributes, Long> {

}
