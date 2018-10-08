package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities;

import java.util.List;
import java.util.Optional;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Getter
@Setter
public class Especialidade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidade_generator")
	@SequenceGenerator(name="especialidade_generator", sequenceName = "especialidade_sequence")
	private Long id;
	
	private String nome;
	
	@ManyToMany(fetch =  FetchType.EAGER)
	@JoinColumn(name = "profissional_id", referencedColumnName = "profissional_id")
	private List<Profissional> profissionais;
	
	public Especialidade(String nome) {
		this.nome = nome;
	}
}
