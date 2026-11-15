package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Solicitacao;
import br.edu.unifio.ecommerce.repositorios.SolicitacaoRepository;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository repository;

    public SolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

    public List<Solicitacao> listar() {
        return repository.findAll();
    }

    public Optional<Solicitacao> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Solicitacao salvar(Solicitacao solicitacao) {

        if (!solicitacao.isAceitouTermo()) {
            throw new RuntimeException("É necessário aceitar os termos para solicitar uma adoção.");
        }

        if (solicitacao.getAn() != null &&
            "ADOTADO".equalsIgnoreCase(solicitacao.getAn().getStatus())) {
            throw new RuntimeException("Não é possível solicitar a adoção de um animal já adotado.");
        }

        return repository.save(solicitacao);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}