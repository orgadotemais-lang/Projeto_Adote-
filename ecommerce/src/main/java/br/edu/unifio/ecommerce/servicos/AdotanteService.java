package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Adotante;
import br.edu.unifio.ecommerce.repositorios.AdotanteRepository;

@Service
public class AdotanteService {

    private final AdotanteRepository repository;

    public AdotanteService(AdotanteRepository repository) {
        this.repository = repository;
    }

    public List<Adotante> listar() {
        return repository.findAll();
    }

    public Optional<Adotante> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Adotante salvar(Adotante adotante) {
        return repository.save(adotante);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}