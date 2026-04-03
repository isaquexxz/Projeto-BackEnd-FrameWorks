package model;

public class Aluno {

    //atributos
    private String primeiroNome;
    private String ultimoNome;
    private String dataDeNascimento;

    //Construtor
    public Aluno(String primeiroNome, String ultimoNome, String dataDeNascimeto) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataDeNascimento = dataDeNascimeto;
    }

    //metodos
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

}
