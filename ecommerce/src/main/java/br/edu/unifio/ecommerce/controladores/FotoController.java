package br.edu.unifio.ecommerce.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Foto;
import br.edu.unifio.ecommerce.servicos.FotoService;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private final FotoService service;

    public FotoController(FotoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Foto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foto> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Foto salvar(@RequestBody Foto foto) {
        return service.salvar(foto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}