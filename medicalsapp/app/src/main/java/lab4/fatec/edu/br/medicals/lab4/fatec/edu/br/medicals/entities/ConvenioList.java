package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.conexao.rest.Conexao;

public class ConvenioList {
    private List<Convenio> convenios = new LinkedList<>();

    public ConvenioList() throws Exception {
        String url = "http://localhost:8081/convenios";
        convenios = Conexao.findAllItems(new JSONArray(Conexao.getJSONFromAPI(url)));
    }

    public void initializeConvenios(){
        Endereco end1 = new Endereco("Rua das Acácias",23,"Jardim Portugal","São José dos campos");
        Profissional p1 = new Profissional.Builder(123,"Adriano Mota e Souza")
                .setEndereco(end1)
                .build();
        Profissional p2 = new Profissional.Builder(456,"Fernando Souza de Freitas")
                .setEndereco(new Endereco("Rua Ostra",12,"Capuava","São José dos campos"))
                .build();
        Profissional p3 = new Profissional.Builder(789,"Adriano Mota e Souza")
                .setEndereco(new Endereco("Rua Nepomuceno Novaes",234,"Souza Freitas","Campinas"))
                .build();
        Profissional p4 = new Profissional.Builder(147,"Adriano Mota e Souza")
                .setEndereco(new Endereco("Rua Torre Alta",1090,"Jardim Estoril","São José dos campos"))
                .build();
        //Criação do Convênio Sulamérica
        Convenio c1 = new Convenio(1,"SULAMÉRICA");
        Especialidade e1 = new Especialidade("Cardiologia");
        e1.addProfissional(p1);
        e1.addProfissional(p2);
        e1.addProfissional(p3);
        c1.adicionarEspecialidade(e1);
        convenios.add(c1);
        //Criação do Convênio Grupo São José
        Convenio c2 = new Convenio(2,"GRUPO SÃO JOSÉ");
        Especialidade e2 = new Especialidade("Angiologista");
        e2.addProfissional(p2);
        e2.addProfissional(p3);
        e2.addProfissional(p4);
        c2.adicionarEspecialidade(e2);
        convenios.add(c2);
        //Criação do Convênio Unimed
        Convenio c3 = new Convenio(3,"UNIMED");
        Especialidade e3 = new Especialidade("Oftalmologista");
        e3.addProfissional(p1);
        e3.addProfissional(p3);
        c3.adicionarEspecialidade(e3);
        convenios.add(c3);
        //Criação do Convênio Bradesco Saúde
        Convenio c4 = new Convenio(4,"BRADESCO SAÚDE");
        Especialidade e4 = new Especialidade("Dermatologista");
        e4.addProfissional(p2);
        e4.addProfissional(p2);
        e4.addProfissional(p3);
        e4.addProfissional(p4);
        c4.adicionarEspecialidade(e4);
        convenios.add(c4);
    }

    public List<Profissional> buscarDetalhesDeProfissionaisPorEspecialidade(Convenio convenio,Especialidade especialidade){
        Especialidade especialidadeRetorno = null;
        for (Convenio c:this.convenios) {
            especialidadeRetorno = c.buscarEspecialidade(especialidade);
            if(especialidadeRetorno==null){
                return null;
            }
            if(c.getNome().equals(convenio.getNome())&&
                    especialidadeRetorno.getNome().equals(especialidade.getNome())) {
                return especialidadeRetorno.getProfissionais();
            }
        }
        return null;
    }

    public List<String>getTitulosConvenios(){
        List<String> titulosConvenios = new ArrayList<>();
        for (Convenio c:this.convenios) {
            titulosConvenios.add(c.getNome());
        }
        return titulosConvenios;
    }

    public List<String>getTitulosEspecialidades() {
        List<String> titulosEspecialidades = new ArrayList<>();
        for (Convenio c : this.convenios) {
            for (Especialidade esp : c.getEspecialidades()) {
                titulosEspecialidades.add(esp.getNome());
            }
        }
        return titulosEspecialidades;
    }
}