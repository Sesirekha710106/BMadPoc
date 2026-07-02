package org.example;

import org.example.model.CollectionItem;
import org.example.repository.CollectionItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CollectionItemRepositoryTest {

    @Autowired
    private CollectionItemRepository collectionItemRepository;

    @Test
    void saveAndFindCollectionItem() {
        CollectionItem item = new CollectionItem("Brown Brim", "https://i.ibb.co/ZYW3VTp/brown-brim.png", new BigDecimal("25.00"));
        CollectionItem saved = collectionItemRepository.save(item);
        assertNotNull(saved.getId(), "Saved CollectionItem should have generated id");

        Optional<CollectionItem> found = collectionItemRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "CollectionItem should be found by id");
        assertEquals("Brown Brim", found.get().getName());
        assertEquals(new BigDecimal("25.00"), found.get().getPrice());
    }
}

