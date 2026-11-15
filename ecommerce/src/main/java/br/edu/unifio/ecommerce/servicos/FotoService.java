package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Foto;
import br.edu.unifio.ecommerce.repositorios.FotoRepository;

@Service
public class FotoService {

    private final FotoRepository repository;

    public FotoService(FotoRepository repository) {
        this.repository = repository;
    }

    public List<Foto> listar() {
        return repository.findAll();
    }

    public Optional<Foto> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Foto salvar(Foto foto) {
        return repository.save(foto);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}