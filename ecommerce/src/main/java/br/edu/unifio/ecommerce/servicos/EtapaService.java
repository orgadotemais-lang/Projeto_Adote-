package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Etapa;
import br.edu.unifio.ecommerce.repositorios.EtapaRepository;

@Service
public class EtapaService {

    private final EtapaRepository repository;

    public EtapaService(EtapaRepository repository) {
        this.repository = repository;
    }

    public List<Etapa> listar() {
        return repository.findAll();
    }

    public Optional<Etapa> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Etapa salvar(Etapa etapa) {
        return repository.save(etapa);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}