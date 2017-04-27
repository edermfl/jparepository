package com.example.repository;

import com.example.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eml on 27/04/17.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByRg(String pRg);

    public Cliente findByRgAndNome (String pRg, String pNome);

    /**
     * Usando JPql
     * @param pPrimeiroNome
     * @return lista de clientes com primeiro nome igual ao informado
     */
    @Query("SELECT c FROM Cliente c WHERE c.nome like ?1%")
    public List<Cliente> findAllByFirstName(String pPrimeiroNome);

    /**
     * Usando SQL nativo
     * @param pUltimoNome
     * @return lista de clientes com último nome igual ao informado
     */
    @Query(value = "SELECT c.* FROM CLIENTE c WHERE c.NOME like %?1", nativeQuery = true)
    public List<Cliente> findAllByLastName(String pUltimoNome);

    
}
