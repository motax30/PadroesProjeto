package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Convenio {
    private Integer id;
    private String nome;
    private List<Especialidade> especialidades;
    private List<Profissional> profissionais;

    public Convenio(String nome) {
        this.nome = nome;
    }

    public Convenio(Integer id,String nome) {
        this.id = id;
        this.nome = nome;
        especialidades = new LinkedList<>();
    }

    public void adicionarEspecialidade(Especialidade especialidade){
        getEspecialidades().add(especialidade);
    }

    public Especialidade buscarEspecialidade(Especialidade especialidade){
        for (Especialidade e:getEspecialidades()) {
            if(e.getNome().equals(especialidade.getNome())){
                return e;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convenio convenio = (Convenio) o;
        return Objects.equals(id, convenio.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}