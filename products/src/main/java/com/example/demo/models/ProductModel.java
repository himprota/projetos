package com.example.demo.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity


@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull @Size(min = 4,max = 255)
    @Column(name = "nome") //opcional, se você quiser alterar o nome da tabela
    private String nome;

    private BigDecimal valor;

}
