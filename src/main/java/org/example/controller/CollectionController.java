package org.example.controller;

import org.example.dto.CollectionRequest;
import org.example.model.Collection;
import org.example.service.CollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PostMapping
    public ResponseEntity<Collection> create(@Valid @RequestBody CollectionRequest request) {
        System.out.println("Request Parameters: title=" + request.getTitle() + ", quantity=" + request.getQuantity());
        Collection saved = collectionService.createCollection(request);
        System.out.println("Saved Collection: " + saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

