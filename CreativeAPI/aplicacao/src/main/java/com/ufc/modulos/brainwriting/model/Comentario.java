package com.ufc.modulos.brainwriting.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ufc.util.json.CalendarDeserialize;
import com.ufc.util.json.CalendarSerialize;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(BrainwritingViews.ComentarioView.class)
	private Long id;

	@Column(columnDefinition = "TEXT")
	@JsonView(BrainwritingViews.ComentarioView.class)
	private String texto;

	@JsonSerialize(using = CalendarSerialize.class)
	@JsonDeserialize(using = CalendarDeserialize.class)
	@JsonView(BrainwritingViews.ComentarioView.class)
	private Calendar data;

	@ManyToOne
	@JsonView(BrainwritingViews.ComentarioView.class)
	private PessoaBrainwriting autor;

	@ManyToOne
	@JsonView(BrainwritingViews.ComentarioView.class)
	private IdeiaBrainwriting ideia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public PessoaBrainwriting getAutor() {
		return autor;
	}

	public void setAutor(PessoaBrainwriting autor) {
		this.autor = autor;
	}

	public IdeiaBrainwriting getIdeia() {
		return ideia;
	}

	public void setIdeia(IdeiaBrainwriting ideia) {
		this.ideia = ideia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
