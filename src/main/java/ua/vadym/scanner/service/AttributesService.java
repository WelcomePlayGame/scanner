package ua.vadym.scanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vadym.scanner.models.Attributes;
import ua.vadym.scanner.models.Scanner;
import ua.vadym.scanner.repository.AttributesRepository;
import ua.vadym.scanner.repository.ScannerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AttributesService {

    private final AttributesRepository attributesRepository;
    private final ScannerRepository scannerRepository;

    @Autowired
    public AttributesService(AttributesRepository attributesRepository, ScannerRepository scannerRepository) {
        this.attributesRepository = attributesRepository;
        this.scannerRepository = scannerRepository;
    }


    //get List meansurements
    public List<Attributes> getListAttributes() {
        return attributesRepository.findAll();
    }


    public Attributes getAttributes(long id) {
        Optional<Attributes> attributes = attributesRepository.findById(id);
        return attributes.orElse(null);
    }

    @Transactional
    public void deleteAttributesById(long id) {
        attributesRepository.deleteById(id);
    }

    @Transactional
    public void deleteAttributes() {
        attributesRepository.deleteAll();;
    }


    @Transactional
    public void addAttributes(Attributes attributes, Scanner scanner) {
        attributes.setNowTime(LocalDate.now());
        attributes.setScanner(scanner);
        scanner.setAttributes(attributes);
        scannerRepository.save(scanner);
        attributesRepository.save(attributes);
    }
}
