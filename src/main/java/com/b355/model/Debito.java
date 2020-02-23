package com.b355.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="debito")
@Entity
public class Debito {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="debito_id")
    Long id;

    @Column(name="debito_item")
    private String item;

    @Column(name="debito_valor")
    private double valor;
}
