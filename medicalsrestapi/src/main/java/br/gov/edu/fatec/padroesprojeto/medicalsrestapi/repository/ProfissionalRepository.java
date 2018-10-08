package br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Profissional;


@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

}
