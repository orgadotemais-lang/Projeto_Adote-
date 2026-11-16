
package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Animal;
import br.edu.unifio.ecommerce.entidades.Solicitacao;
import br.edu.unifio.ecommerce.excecoes.RegraNegocioException;
import br.edu.unifio.ecommerce.repositorios.AnimalRepository;
import br.edu.unifio.ecommerce.repositorios.SolicitacaoRepository;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository repository;
    private final AnimalRepository animalRepository;

    public SolicitacaoService(
            SolicitacaoRepository repository,
            AnimalRepository animalRepository) {
        this.repository = repository;
        this.animalRepository = animalRepository;
    }

    public List<Solicitacao> listar() {
        return repository.findAll();
    }

    public List<Solicitacao> buscarPorStatus(String status) {
        return repository.buscarPorStatus(status);
    }

    public Optional<Solicitacao> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Solicitacao salvar(Solicitacao solicitacao) {

        if (!solicitacao.isAceitouTermo()) {
            throw new RegraNegocioException(
                "É necessário aceitar os termos para solicitar uma adoção.");
        }

        if (solicitacao.getAn() != null) {

            Animal animal = animalRepository
                .findById(solicitacao.getAn().getId())
                .orElseThrow(() ->
                    new RegraNegocioException("Animal não encontrado."));

            if ("ADOTADO".equalsIgnoreCase(animal.getStatus())) {
                throw new RegraNegocioException(
                    "Não é possível solicitar a adoção de um animal já adotado.");
            }

            solicitacao.setAn(animal);
        }

        return repository.save(solicitacao);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
