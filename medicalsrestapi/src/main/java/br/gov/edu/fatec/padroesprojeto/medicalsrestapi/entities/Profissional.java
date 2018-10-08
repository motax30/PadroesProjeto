package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Data
@ToString
public class Profissional {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissional_generator")
	@SequenceGenerator(name="profissional_generator", sequenceName = "profissional_sequence")
	private Long id;
	@NotEmpty
	private String nome;
	@Column(length = 8, nullable = true)
	private Integer crm;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Especialidade> especialidades;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Convenio> convenios;
	@OneToOne
	private Endereco endereco;
	
	public Profissional(String nome,Integer crm, Endereco endereco) {
		this.nome = nome;
		this.crm = crm;
		this.endereco = endereco;
	}
}
