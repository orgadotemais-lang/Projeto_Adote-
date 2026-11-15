package br.edu.unifio.ecommerce.controladores;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Resgate;
import br.edu.unifio.ecommerce.servicos.ResgateService;

@RestController
@RequestMapping("/resgates")
public class ResgateController {

    private final ResgateService service;

    public ResgateController(ResgateService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resgate> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resgate> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resgate salvar(@Valid @RequestBody Resgate resgate) {
        return service.salvar(resgate);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}