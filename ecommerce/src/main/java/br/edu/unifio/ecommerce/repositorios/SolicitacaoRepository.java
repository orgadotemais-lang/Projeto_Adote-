package br.edu.unifio.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.ecommerce.entidades.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {

}