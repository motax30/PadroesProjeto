package br.gov.edu.fatec.padroesprojeto.medicalsrestapi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Convenio;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Endereco;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Especialidade;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.Profissional;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.entities.enuns.Estados;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository.ConvenioRepository;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository.EnderecoRepository;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository.EspecialidadeRepository;
import br.gov.edu.fatec.padroesprojeto.medicalsrestapi.repository.ProfissionalRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalsApiApplicationTests {
	@Autowired
	ConvenioRepository cr;
	@Autowired
	EnderecoRepository er;
	@Autowired
	ProfissionalRepository pr;
	@Autowired
	EspecialidadeRepository espRep;
	@Autowired
	EspecialidadeRepository espRes;
	
//	@Test
//	public void testeResource() {
//		Especialidade especialidade = espRes.getProfissionais(1, 2);
//		for (Profissional profissional : especialidade.getProfissionais()) {
//			System.out.println(profissional.toString());
//		}
//	}
	
	@Test
	public void testeSalvarEntidades() {
		Endereco end1 = new Endereco("Rua Otávio de Moraes Lopes","298","casa","Jardim Americano","São José dos Campos",Estados.SP);
		Endereco end2 = new Endereco("Rua Jorge de Araújo","151","apto","Jardim Portugal","São José dos Campos",Estados.SP);
		Endereco end3 = new Endereco("Rua Henrique Lemes de Albuquerque","154","casa","Jardim das Flores","São José dos Campos",Estados.SP);
		Endereco end4 = new Endereco("Av Santos Never de Mattos","300","casa","Jardim Santana","São José dos Campos",Estados.SP);
		//salvando as entidades e recuperando endereços cadastrados no banco
		end1 = er.saveAndFlush(end1);
		end2 = er.saveAndFlush(end2);
		end3 = er.saveAndFlush(end3);
		end4 = er.saveAndFlush(end4);
		
		Especialidade esp1 = new Especialidade("Cardiologista");
		Especialidade esp2 = new Especialidade("Oftalmologista");
		Especialidade esp3 = new Especialidade("Dentista");
		Especialidade esp4 = new Especialidade("Ginecologista");
		//salvando as entidades e recuperando especialidades cadastrados no banco
		esp1 = espRep.saveAndFlush(esp1);
		esp2 = espRep.saveAndFlush(esp2);
		esp3 = espRep.saveAndFlush(esp3);
		esp4 = espRep.saveAndFlush(esp4);

		Profissional p1 = new Profissional("Adriano Mota e Souza",12345678,end1);
		Profissional p2 = new Profissional("Henrique Gabriel",12345678,end2);
		Profissional p3 = new Profissional("Eduardo dos Santos Mota",12345678,end3);
		Profissional p4 = new Profissional("Juliana Mendes de Araújo",12345678,end4);
		//salvando as entidades e recuperando convenios cadastrados no banco
		p1 = pr.saveAndFlush(p1);
		p2 = pr.saveAndFlush(p2);
		p3 = pr.saveAndFlush(p3);
		p4 = pr.saveAndFlush(p4);
		
		esp1.setProfissionais(Arrays.asList(p1));
		esp2.setProfissionais(Arrays.asList(p1,p2,p4));
		esp3.setProfissionais(Arrays.asList(p3));
		esp4.setProfissionais(Arrays.asList(p4));
		
		List<Especialidade>lstesp1 = Arrays.asList(esp1,esp2);
		p1.setEspecialidades(lstesp1);
		List<Especialidade>lstesp2 = Arrays.asList(esp2);
		p2.setEspecialidades(lstesp2);
		List<Especialidade>lstesp3 = Arrays.asList(esp3);
		p3.setEspecialidades(lstesp3);
		List<Especialidade>lstesp4 = Arrays.asList(esp2,esp4);
		p4.setEspecialidades(lstesp4);
		
		esp1 = espRep.saveAndFlush(esp1);
		esp2 = espRep.saveAndFlush(esp2);
		esp3 = espRep.saveAndFlush(esp3);
		esp4 = espRep.saveAndFlush(esp4);
		
		List<Profissional> lstProfissionais1 = Arrays.asList(p1,p2,p3);
		List<Profissional> lstProfissionais2 = Arrays.asList(p1,p2);
		List<Profissional> lstProfissionais3 = Arrays.asList(p2,p3,p4);
		List<Profissional> lstProfissionais4 = Arrays.asList(p1,p2,p3,p4);
		
		Convenio convenio1 = new Convenio("Grupo São José");
		Convenio convenio2 = new Convenio("Unimed");
		Convenio convenio3 = new Convenio("Sulamérica");
		Convenio convenio4 = new Convenio("Santa Casa");
		//salvando as entidades e recuperando convenios cadastrados no banco
		convenio1 = cr.saveAndFlush(convenio1);
		convenio2 = cr.saveAndFlush(convenio2);
		convenio3 = cr.saveAndFlush(convenio3);
		convenio4 = cr.saveAndFlush(convenio4);
		
		convenio1.setProfissionais(lstProfissionais1);
		convenio2.setProfissionais(lstProfissionais2);
		convenio3.setProfissionais(lstProfissionais3);
		convenio4.setProfissionais(lstProfissionais4);
		
		convenio1 = cr.saveAndFlush(convenio1);
		convenio2 = cr.saveAndFlush(convenio2);
		convenio3 = cr.saveAndFlush(convenio3);
		convenio4 = cr.saveAndFlush(convenio4);
		
		p1.setConvenios(Arrays.asList(convenio1,convenio2));
		p2.setConvenios(Arrays.asList(convenio2));
		p3.setConvenios(Arrays.asList(convenio1,convenio2,convenio3));
		p4.setConvenios(Arrays.asList(convenio3,convenio4));
		
		convenio1.setProfissionais(lstProfissionais1);
		convenio2.setProfissionais(lstProfissionais2);
		convenio3.setProfissionais(lstProfissionais3);
		convenio4.setProfissionais(lstProfissionais4);
		
		pr.saveAndFlush(p1);
		pr.saveAndFlush(p2);
		pr.saveAndFlush(p3);
		pr.saveAndFlush(p4);
		
	}

}
