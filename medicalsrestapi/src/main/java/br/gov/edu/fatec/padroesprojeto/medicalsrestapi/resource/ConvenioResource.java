package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Convenio;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository.ConvenioRepository;

@RestController
@RequestMapping("/")
public class ConvenioResource {
	@Autowired
	ConvenioRepository cr;
	@GetMapping(value = "convenios/{id}", produces="application/json")
	public Optional<Convenio> getConvenioById(@PathVariable(value="id") String id){
		return cr.findById(Long.valueOf(id));
	}
	
	@GetMapping(value = "convenios", produces="application/json")
	public List<Convenio> getConvenios(){
		 List<Convenio>convenios = cr.findAll();
		 return convenios;
	}
	
	@GetMapping(value = "convenios/{nomeConvenio}/{profissional}", produces="application/json")
	public Convenio getConvenioPorNomeEProfissional(@PathVariable(value="nomeConvenio") String nomeConvenio,
															@PathVariable(value="nomeProfissional") String nomeProfissional){
		 Convenio convenio = cr.findByNomeAndProfissionaisNome(nomeConvenio, nomeProfissional);
		 return convenio;
	}
}
