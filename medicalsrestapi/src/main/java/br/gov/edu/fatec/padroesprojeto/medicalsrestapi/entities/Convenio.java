package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Data
public class Convenio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "convenio_generator")
	@SequenceGenerator(name="convenio_generator", sequenceName = "convenio_sequence")
	private Long id;
	private String nome;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "convenios")
	private List<Profissional> profissionais;

	public Convenio(String nome) {
		super();
		this.nome = nome;
	}
	
}
