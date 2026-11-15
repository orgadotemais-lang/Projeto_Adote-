package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Encontrador;
import br.edu.unifio.ecommerce.repositorios.EncontradorRepository;

@Service
public class EncontradorService {

    private final EncontradorRepository repository;

    public EncontradorService(EncontradorRepository repository) {
        this.repository = repository;
    }

    public List<Encontrador> listar() {
        return repository.findAll();
    }

    public Optional<Encontrador> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Encontrador salvar(Encontrador encontrador) {
        return repository.save(encontrador);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}