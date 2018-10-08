package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities;

import java.util.LinkedList;
import java.util.List;

public class Especialidade {
    private String nome;
    private List<Profissional> profissionais;

    public Especialidade(String nome) {
        profissionais = new LinkedList<>();
        this.nome = nome;
    }

    public void addProfissional(Profissional profissional){
        this.profissionais.add(profissional);
    }

    public Profissional buscarProfissional(Profissional profissional){
        for (Profissional p:getProfissionais()) {
            if(p.getCrm().equals(profissional.getCrm())) {
                return p;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }
}
