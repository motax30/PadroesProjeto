package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
	Convenio findByNomeAndProfissionaisNome(String nomeConvenio,String nomeProfissional);
}
