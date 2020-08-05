package org.acme.quarkus.sample;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
@Table(name="PRODUTOS")
public class Produto extends PanacheEntity {
	
	private String nome;
	
	private BigDecimal valo;
	@CreationTimestamp
	private Date dataCriacao;
	
	@UpdateTimestamp
	private Date dataAtualizacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValo() {
		return valo;
	}

	public void setValo(BigDecimal valo) {
		this.valo = valo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	
		

}
