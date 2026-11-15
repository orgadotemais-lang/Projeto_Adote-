
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
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHorario;

    private String status;

    private String tipoMoradia;

    private Integer qtdPessoas;

    private boolean possuiQuintalMorado;

    private boolean possuiTelaProtecao;

    private boolean possuiOutrosAnimais;

    private boolean jaTeveAnimais;

    private String motivoAdocao;

    private boolean aceitouTermo;

    @ManyToOne
    private Adotante ad;

    @ManyToOne
    private Animal an;

    @ManyToOne
    private Organizacao org;

    @OneToMany(mappedBy = "sol")
    private List<Etapa> listaEtapas;
}
