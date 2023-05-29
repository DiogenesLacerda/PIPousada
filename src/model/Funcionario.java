package model;

import java.time.LocalDateTime;
import utils.Utils;

public class Funcionario {
    
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String sexo;
    private LocalDateTime datanasci;
    private String rua;
    private String numero;
    private String bairro;
    private String senha;
    private String logado;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the datanasci
     */
    public LocalDateTime getDatanasci() {
        return datanasci;
    }

    /**
     * @param datanasci the datanasci to set
     */
    public void setDatanasci(LocalDateTime datanasci) {
        this.datanasci = datanasci;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public String dataTostringsql(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHoraSQL(datanasci);
        return data;
    }
    
    public String dataTostring(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHora(datanasci);
        return data;
    }

    /**
     * @return the logado
     */
    public String getLogado() {
        return logado;
    }

    /**
     * @param logado the logado to set
     */
    public void setLogado(String logado) {
        this.logado = logado;
    }
    
}
