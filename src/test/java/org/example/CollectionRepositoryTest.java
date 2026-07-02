package org.example;

import org.example.model.Collection;
import org.example.model.CollectionItem;
import org.example.repository.CollectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CollectionRepositoryTest {

    @Autowired
    private CollectionRepository collectionRepository;

    @Test
    void saveAndFindCollection() {
        // quantity reflects number of items in the frontend collection
        Collection collection = new Collection("Hats", 2);
        Collection saved = collectionRepository.save(collection);
        assertNotNull(saved.getId(), "Saved Collection should have generated id");

        Optional<Collection> found = collectionRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "Collection should be found by id");
        assertEquals("Hats", found.get().getTitle());
        assertEquals(2, found.get().getQuantity());
    }
}

