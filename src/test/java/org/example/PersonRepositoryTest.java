package org.example;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void saveAndFindById() {
        Person p = new Person("Alice");
        Person saved = personRepository.save(p);
        assertNotNull(saved.getId(), "Saved person should have generated id");

        Optional<Person> found = personRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "Person should be found by id");
        assertEquals("Alice", found.get().getName());
    }
}


