package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.enuns.Estados;
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
public class Endereco {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_generator")
	@SequenceGenerator(name="endereco_generator", sequenceName = "endereco_sequence")
	private Long id;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private Estados uf;
	public Endereco(String rua, String numero, String complemento, String bairro, String cidade, Estados uf) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	
	
}
