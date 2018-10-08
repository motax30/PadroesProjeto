package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities;

import java.util.List;
import java.util.Objects;

public class Profissional {
    private Long id;
    private Integer crm;
    private String nome;
    private List<Especialidade> especialidades;
    private List<Convenio> convenios;
    private Endereco endereco;

    public Profissional(Integer crm, String nome, List<Especialidade> especialidades,List<Convenio> convenios, Endereco endereco) {
        setCrm(crm);
        setNome(nome);
        setEndereco(endereco);
        setEspecialidades(especialidades);
        setConvenios(convenios);
    }

    public static class Builder {
        private Long id;
        private Integer crm;
        private String nome;
        private List<Especialidade> especialidades;
        private List<Convenio> convenios;
        private Endereco endereco;

        public Builder(Integer crm, String nome){
            this.crm = crm;
            this.nome = nome;
        }

        public Builder setEndereco(Endereco endereco){
            this.endereco = endereco;
            return this;
        }

        public Builder setEspecialidades(List<Especialidade> especialidades){
            this.especialidades = especialidades;
            return this;
        }

        public Builder setConvenios(List<Convenio>convenios){
            this.setConvenios(convenios);
            return this;
        }

        public Profissional build(){
            return new Profissional(crm,nome,especialidades,convenios,endereco);
        }
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return Objects.equals(crm, that.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm);
    }

    @Override
    public String toString() {
        return "Nome: "+getNome()+"\n"+"Crm: "+getCrm()+"\n"+getEndereco().toString();
    }
}