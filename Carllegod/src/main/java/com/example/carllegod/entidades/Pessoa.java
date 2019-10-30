package com.example.carllegod.entidades;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "Pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 50, nullable = false)
    private String nome;

    // - Esperar um milagre acontecer para uma restrição de data que a idade seja maior de 18:
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    public Pessoa(){}

    public Pessoa(String nome, Date dtNascimento){
        //coloarset:
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setIdade(Date idade) {
        this.dtNascimento = idade;
    }


}
