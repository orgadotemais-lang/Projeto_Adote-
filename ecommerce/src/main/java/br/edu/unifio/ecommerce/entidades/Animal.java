
package br.edu.unifio.ecommerce.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String especie;
    private String raca;
    private String porte;
    private String sexo;
    private String cor;
    private String temperamento;

    private LocalDate dataNascimento;

    private boolean castrado;
    private boolean vacinado;

    private String descricao;
    private String status;

    private LocalDateTime dataCadastro;

    @ManyToOne
    private Organizacao org;

    @JsonIgnore
    @OneToMany(mappedBy = "an")
    private List<Solicitacao> listaSolicitacoes;

    @OneToMany(mappedBy = "an")
    private List<Foto> listaFotos;
}

