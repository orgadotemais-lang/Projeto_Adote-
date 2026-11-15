
package br.edu.unifio.ecommerce.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adotante extends Usuario {

    private String cpf;

   @OneToMany(mappedBy = "ad")
    private List<Solicitacao> listaSolicitacoes;
}
