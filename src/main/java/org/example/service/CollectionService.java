package org.example.service;

import org.example.dto.CollectionRequest;
import org.example.model.Collection;
import org.example.repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Collection createCollection(CollectionRequest request) {
        Collection c = new Collection(request.getTitle(), request.getQuantity());
        return collectionRepository.save(c);
    }

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Optional<Collection> getCollectionById(Long id) {
        return collectionRepository.findById(id);
    }
}

