package com.example.carllegod.entidades;

import org.hibernate.annotations.Check;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Automoveis")
@Check ( constraints = "placa LIKE '___-____'" )
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, length = 8)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @ManyToOne
    private Pessoa proprietaria;

    public Automovel(){

    }

    public Automovel(String placa, String modelo, Pessoa proprietaria){
        this.placa = placa;
        this.modelo = modelo;
        this.proprietaria = proprietaria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Pessoa getProprietaria() {
        if(proprietaria == null){
            return new Pessoa();
        }
        return proprietaria;
    }

    public void setProprietaria(Pessoa proprietaria) {
        this.proprietaria = proprietaria;
    }

}
