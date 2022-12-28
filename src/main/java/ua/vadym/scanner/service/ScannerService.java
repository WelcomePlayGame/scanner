package ua.vadym.scanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vadym.scanner.models.Scanner;
import ua.vadym.scanner.repository.ScannerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ScannerService {
    private final ScannerRepository scannerRepository;

    @Autowired
    public ScannerService(ScannerRepository scannerRepository) {
        this.scannerRepository = scannerRepository;
    }


    //get list Scanner for users
    public List<Scanner> getScannerList() {
    return scannerRepository.findAll();
    }

    //get information Scanner
    public Scanner getScanner (long id ) {
        Optional<Scanner> findScanner = scannerRepository.findById(id);
        return findScanner.orElse(null);
    }


    //add scanner for list
    @Transactional
    public void addScanner(Scanner scanner) {
    scannerRepository.save(scanner);
    }
    //delete scanner of list
    @Transactional
    public void deleteScanner(long id) {
        scannerRepository.deleteById(id);
    }

    @Transactional
    public void deleteScannerAll() {
        scannerRepository.deleteAll();;
    }

}
