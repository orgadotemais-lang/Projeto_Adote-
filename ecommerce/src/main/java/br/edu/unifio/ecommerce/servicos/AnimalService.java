
package br.edu.unifio.ecommerce.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unifio.ecommerce.entidades.Animal;
import br.edu.unifio.ecommerce.repositorios.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<Animal> listar() {
        return repository.findAll();
    }

    public Optional<Animal> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Animal> buscarPorStatus(String status) {
        return repository.buscarPorStatus(status);
    }

    public Animal salvar(Animal animal) {
        return repository.save(animal);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
