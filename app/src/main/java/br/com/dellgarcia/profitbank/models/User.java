package br.com.dellgarcia.profitbank.models;

public class User {

    private String nome;
    private String email;
    private String pass;

    public User(String nome, String email, String pass) {
        this.nome = nome;
        this.email = email;
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
