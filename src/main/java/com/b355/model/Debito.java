package com.b355.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Debito {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    private String item;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Debito{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", valor=" + valor +
                '}';
    }
}
