package br.edu.unifio.ecommerce.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unifio.ecommerce.entidades.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {

    @Query("SELECT s FROM Solicitacao s WHERE s.status = :status")
    List<Solicitacao> buscarPorStatus(@Param("status") String status);

}