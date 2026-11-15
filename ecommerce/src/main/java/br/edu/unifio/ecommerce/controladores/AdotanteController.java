
package br.edu.unifio.ecommerce.controladores;

import java.util.List;

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
    public Adotante salvar(@RequestBody Adotante adotante) {
        return service.salvar(adotante);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}
