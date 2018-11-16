package lab4.fatec.edu.br.medicals.lab4.fatec.edu.br.medicals.entities;

public class Endereco {

    private Long id;
    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private Estados uf;

    public Endereco(String rua, Integer numero, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Endereco: \n" +
                "Rua: " + getRua()+ "\n" +
                ", Numero: " + getNumero() +"\n" +
                ", Bairro: " + getBairro() + "\n" +
                ", Cidade: " + getCidade()+ "\n\n";
    }


}
