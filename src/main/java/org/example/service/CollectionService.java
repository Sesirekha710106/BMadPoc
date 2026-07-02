package org.example.service;

import org.example.dto.CollectionRequest;
import org.example.model.Collection;
import org.example.repository.CollectionRepository;
import org.springframework.stereotype.Service;

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
}

