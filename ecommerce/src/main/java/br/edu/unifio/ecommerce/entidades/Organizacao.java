
package br.edu.unifio.ecommerce.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Organizacao extends Usuario {

    private String cnpj;
    private String nomeOrg;
    private String statusValidacao;

    @OneToMany(mappedBy = "org")
    private List<Animal> listaAnimais;

    @OneToMany(mappedBy = "org")
    private List<Solicitacao> listaSolicitacoes;

    @OneToMany(mappedBy = "org")
    private List<Resgate> listaResgates;
}
