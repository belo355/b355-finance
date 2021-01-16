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

    @Override
    public String toString() {
        return "Debito{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", valor=" + valor +
                '}';
    }
}
