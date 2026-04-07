package model;

public class Carro {

    //atributos
    private int id;
    private String nomeCarro;
    private String valorCarro;
    private String anoCarro;

    //Construtor
    public Carro(int id, String nomeCarro, String valorCarro, String anoCarro) {
        this.id = id;
        this.nomeCarro = nomeCarro;
        this.valorCarro = valorCarro;
        this.anoCarro = anoCarro;
    }

    //metodos


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String primeiroNome) {
        this.nomeCarro = nomeCarro;
    }

    public String getValorCarro() {
        return valorCarro;
    }

    public void setValorCarro(String ultimoNome) {
        this.valorCarro = valorCarro;
    }

    public String getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(String ano) {
        this.anoCarro = anoCarro;
    }

}
