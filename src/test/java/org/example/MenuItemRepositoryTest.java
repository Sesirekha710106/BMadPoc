package org.example;

import org.example.model.MenuItem;
import org.example.repository.MenuItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MenuItemRepositoryTest {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Test
    void saveAndFindMenuItem() {
        MenuItem menuItem = new MenuItem("Hats", "https://example.com/hats.png", "medium", "shop/hats");
        MenuItem saved = menuItemRepository.save(menuItem);
        assertNotNull(saved.getId(), "Saved MenuItem should have generated id");

        Optional<MenuItem> found = menuItemRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "MenuItem should be found by id");
        assertEquals("Hats", found.get().getTitle());
        assertEquals("shop/hats", found.get().getLinkUrl());
    }
}

