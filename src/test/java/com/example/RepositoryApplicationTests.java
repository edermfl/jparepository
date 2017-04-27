package com.example;

import com.example.model.Cliente;
import com.example.repository.ClienteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryApplicationTests {

    @Autowired
    ClienteRepository repository;

    @Test
    public void testRepository(){
        repository.save(new Cliente("Maria Oliveira","123456789"));
        repository.save(new Cliente("José da Silva","987654321"));
        repository.save(new Cliente("Maria da Silva","999999999"));

	final List<Cliente> todos = repository.findAll();
	System.out.println(todos);
	Assert.assertEquals(3, todos.size());

	final Cliente maria = repository.findByRg("123456789");
	System.out.println(maria);
	Assert.assertEquals("Maria Oliveira", maria.getNome());

	final List<Cliente> marias = repository.findAllByFirstName("Maria");
	System.out.println(marias);
	Assert.assertEquals(2, marias.size());

	final List<Cliente> silvas = repository.findAllByLastName("Silva");
	System.out.println(silvas);
	Assert.assertEquals(2, silvas.size());

    }

    @Test
    public void contextLoads() {
    }

}
