package model;

import java.time.LocalDateTime;
import utils.Utils;

public class Reserva {
    
    private int id;
    private LocalDateTime dtentrada;
    private LocalDateTime dtsaida;
    private LocalDateTime dtreserva;
    private double valor;
    private String observacoes;
    private int clientid;
    private int quartoid;
    private int fpagid;
    private String cliente;
    private String cliente_cpf;
    private String fpag;
    private String numquarto;
    private String Status;

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
     * @return the dtentrada
     */
    public LocalDateTime getDtentrada() {
        return dtentrada;
    }

    /**
     * @param dtentrada the dtentrada to set
     */
    public void setDtentrada(LocalDateTime dtentrada) {
        this.dtentrada = dtentrada;
    }

    /**
     * @return the dtsaida
     */
    public LocalDateTime getDtsaida() {
        return dtsaida;
    }

    /**
     * @param dtsaida the dtsaida to set
     */
    public void setDtsaida(LocalDateTime dtsaida) {
        this.dtsaida = dtsaida;
    }

    /**
     * @return the dtreserva
     */
    public LocalDateTime getDtreserva() {
        return dtreserva;
    }

    /**
     * @param dtreserva the dtreserva to set
     */
    public void setDtreserva(LocalDateTime dtreserva) {
        this.dtreserva = dtreserva;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the clientid
     */
    public int getClientid() {
        return clientid;
    }

    /**
     * @param clientid the clientid to set
     */
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    /**
     * @return the quartoid
     */
    public int getQuartoid() {
        return quartoid;
    }

    /**
     * @param quartoid the quartoid to set
     */
    public void setQuartoid(int quartoid) {
        this.quartoid = quartoid;
    }

    /**
     * @return the fpagid
     */
    public int getFpagid() {
        return fpagid;
    }

    /**
     * @param fpagid the fpagid to set
     */
    public void setFpagid(int fpagid) {
        this.fpagid = fpagid;
    }


    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    /**
     * @return the fpag
     */
    public String getFpag() {
        return fpag;
    }

    /**
     * @param fpag the fpag to set
     */
    public void setFpag(String fpag) {
        this.fpag = fpag;
    }

    /**
     * @return the numquarto
     */
    public String getNumquarto() {
        return numquarto;
    }

    /**
     * @param numquarto the numquarto to set
     */
    public void setNumquarto(String numquarto) {
        this.numquarto = numquarto;
    }

    /**
     * @return the cliente_cpf
     */
    public String getCliente_cpf() {
        return cliente_cpf;
    }

    /**
     * @param cliente_cpf the cliente_cpf to set
     */
    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String dataentradaTostringsql(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHoraSQL(dtentrada);
        return data;
    }
    
     public String datasaidaTostringsql(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHoraSQL(dtsaida);
        return data;
    }
    
    public String dataentradaTostring(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHora(dtentrada);
        return data;
    }
    
    public String datasaidaTostring(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHora(dtsaida);
        return data;
    }
    
    public String datareservadaTostring(){
        String data;
        Utils date = new Utils(); 
        
        data = date.formatarDataHora(dtreserva);
        return data;
    }
    
}
