
package br.edu.unifio.ecommerce.controladores;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Animal;
import br.edu.unifio.ecommerce.servicos.AnimalService;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Animal> listar() {
        return service.listar();
    }

    @GetMapping("/status/{status}")
    public List<Animal> buscarPorStatus(@PathVariable String status) {
        return service.buscarPorStatus(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal salvar(@Valid @RequestBody Animal animal) {
        return service.salvar(animal);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(
        @PathVariable Integer id,
        @Valid @RequestBody Animal animal) {

        return service.buscarPorId(id)
            .map(animalExistente -> {
                animal.setId(id);
                return ResponseEntity.ok(service.salvar(animal));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
