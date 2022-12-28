package ua.vadym.scanner.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.vadym.scanner.dto.ScannerDTO;
import ua.vadym.scanner.models.Scanner;
import ua.vadym.scanner.service.ScannerService;

import java.util.List;

@RestController
@RequestMapping(path = "/scanners", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class ScannerController {

    private  final ScannerService scannerService;
    private final ModelMapper modelMapper;

    public ScannerController(ScannerService scannerService, ModelMapper modelMapper) {
        this.scannerService = scannerService;

        this.modelMapper = modelMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Scanner> scannerList () {
        return scannerService.getScannerList();
    }

    @GetMapping(path = "{id}")
    public Scanner getScanner (@PathVariable("id") long id) {
        return scannerService.getScanner(id);
    }


    @PostMapping(path = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Scanner addScanner(@RequestBody Scanner scanner) {
        scannerService.addScanner(scanner);
        return scanner;
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScanner(@PathVariable("id") long id) {
        scannerService.deleteScanner(id);
    }


    @DeleteMapping(path = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScannerAll() {
        scannerService.deleteScannerAll();
    }




    public Scanner convertToScanner (ScannerDTO scannerDTO) {
        return modelMapper.map(scannerDTO, Scanner.class);
    }
}
