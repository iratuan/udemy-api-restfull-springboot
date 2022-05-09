package com.wallet.core.repository;

import com.wallet.core.entity.User;
import net.bytebuddy.matcher.ElementMatcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    private static final String EMAIL = "cicrano@teste.com";

    @Before
    public void setUp() {
        User user = new User();
        user.setName("Cicrano");
        user.setPassword("123456");
        user.setEmail(EMAIL);
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void deveSalvarUmUsuario() {

        User user = new User();
        user.setName("Fulano");
        user.setPassword("123456");
        user.setEmail("fulano@teste.com");
        User savedUser = repository.save(user);

        assertNotNull(savedUser);
    }

    @Test
    public void deveBuscarUmUsuarioPorEmail() {
        Optional<User> user = repository.findByEmail(EMAIL);
        assertTrue(user.isPresent());
        assertEquals(user.get().getEmail(), EMAIL);

    }
}
