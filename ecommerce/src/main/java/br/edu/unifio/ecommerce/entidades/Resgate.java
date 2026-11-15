
package br.edu.unifio.ecommerce.entidades;

import java.time.LocalDateTime;
import java.util.List;

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
public class Resgate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String protocolo;

    private LocalDateTime dataHorario;

    private String localizacao;

    private String especie;

    private String porte;

    private String condicaoAnimal;

    private String status;

    @ManyToOne
    private Organizacao org;

    @ManyToOne
    private Encontrador enc;

    @OneToMany(mappedBy = "r")
    private List<Foto> listaFotos;
}
