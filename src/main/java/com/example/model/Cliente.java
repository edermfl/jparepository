package com.example.model;

import javax.persistence.*;

/**
 * Created by eml on 27/04/17.
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    Cliente() {
    }

    @Column
    private String rg;

    public Long getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    public Cliente(final String pNome, final String pRg) {
	nome = pNome;
	rg = pRg;
    }

    public String getRg() {
	return rg;
    }

    public void setId(final Long pId) {
	id = pId;
    }

    public void setNome(final String pNome) {
	nome = pNome;
    }

    public void setRg(final String pRg) {
	rg = pRg;
    }

    @Override public String toString() {
	return "Cliente{" +
			"id=" + id +
			", nome='" + nome + '\'' +
			", rg='" + rg + '\'' +
			'}';
    }
}
