package com.b355.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="credito")
@Entity
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private double valor;

    @Override
    public String toString() {
        return "Credito{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", valor=" + valor +
                '}';
    }
}
