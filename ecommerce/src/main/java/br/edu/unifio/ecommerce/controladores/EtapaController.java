package br.edu.unifio.ecommerce.controladores;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Etapa;
import br.edu.unifio.ecommerce.servicos.EtapaService;

@RestController
@RequestMapping("/etapas")
public class EtapaController {

    private final EtapaService service;

    public EtapaController(EtapaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etapa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etapa> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Etapa salvar(@Valid @RequestBody Etapa etapa) {
        return service.salvar(etapa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}