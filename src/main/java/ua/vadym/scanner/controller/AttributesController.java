package ua.vadym.scanner.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.vadym.scanner.models.Attributes;
import ua.vadym.scanner.models.Scanner;
import ua.vadym.scanner.service.AttributesService;
import ua.vadym.scanner.service.ScannerService;

import java.util.List;

@RestController
@RequestMapping(path = "/means", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class AttributesController {

    private final AttributesService attributesService;
    private final ModelMapper modelMapper;

    public AttributesController(AttributesService attributesService, ScannerService scannerService, ModelMapper modelMapper) {
        this.attributesService = attributesService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Attributes> getAllAttributes() {
    return attributesService.getListAttributes();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Attributes getAttributes(@PathVariable("id") long id) {
        return attributesService.getAttributes(id);
    }


    @DeleteMapping(path = "/{id}", produces = {"application/json", "application/text"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAttributeById(@PathVariable("id") long id) {

    }

    @DeleteMapping(path = "/delete", produces = {"application/json", "application/text"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllAttributes() {
       attributesService.deleteAttributes();
    }


    @PostMapping(path = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Attributes saveAttributes(@RequestBody Attributes attributes,@RequestBody Scanner scanner) {
        attributesService.addAttributes(attributes, scanner);
         return attributes;
    }

}
