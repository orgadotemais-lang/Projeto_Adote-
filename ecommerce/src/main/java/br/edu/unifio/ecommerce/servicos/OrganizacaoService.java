package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Organizacao;
import br.edu.unifio.ecommerce.repositorios.OrganizacaoRepository;

@Service
public class OrganizacaoService {

    private final OrganizacaoRepository repository;

    public OrganizacaoService(OrganizacaoRepository repository) {
        this.repository = repository;
    }

    public List<Organizacao> listar() {
        return repository.findAll();
    }

    public Optional<Organizacao> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Organizacao salvar(Organizacao organizacao) {
        return repository.save(organizacao);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}