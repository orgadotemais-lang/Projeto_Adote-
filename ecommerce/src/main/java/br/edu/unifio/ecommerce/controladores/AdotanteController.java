package br.edu.unifio.ecommerce.controladores;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Adotante;
import br.edu.unifio.ecommerce.servicos.AdotanteService;

@RestController
@RequestMapping("/adotantes")
public class AdotanteController {

    private final AdotanteService service;

    public AdotanteController(AdotanteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Adotante> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adotante> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Adotante salvar(@Valid @RequestBody Adotante adotante) {
        return service.salvar(adotante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adotante> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Adotante adotante) {

        return service.buscarPorId(id)
                .map(adotanteExistente -> {
                    adotante.setId(id);
                    return ResponseEntity.ok(service.salvar(adotante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}