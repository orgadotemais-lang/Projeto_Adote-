package br.edu.unifio.ecommerce.controladores;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Encontrador;
import br.edu.unifio.ecommerce.servicos.EncontradorService;

@RestController
@RequestMapping("/encontradores")
public class EncontradorController {

    private final EncontradorService service;

    public EncontradorController(EncontradorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Encontrador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encontrador> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Encontrador salvar(@Valid @RequestBody Encontrador encontrador) {
        return service.salvar(encontrador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encontrador> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Encontrador encontrador) {

        return service.buscarPorId(id)
                .map(encontradorExistente -> {
                    encontrador.setId(id);
                    return ResponseEntity.ok(service.salvar(encontrador));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}