package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Resgate;
import br.edu.unifio.ecommerce.repositorios.ResgateRepository;

@Service
public class ResgateService {

    private final ResgateRepository repository;

    public ResgateService(ResgateRepository repository) {
        this.repository = repository;
    }

    public List<Resgate> listar() {
        return repository.findAll();
    }

    public Optional<Resgate> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Resgate salvar(Resgate resgate) {
        return repository.save(resgate);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}