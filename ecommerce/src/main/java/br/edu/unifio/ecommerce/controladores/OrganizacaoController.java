package br.edu.unifio.ecommerce.controladores;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Organizacao;
import br.edu.unifio.ecommerce.servicos.OrganizacaoService;

@RestController
@RequestMapping("/organizacoes")
public class OrganizacaoController {

    private final OrganizacaoService service;

    public OrganizacaoController(OrganizacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Organizacao> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizacao> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Organizacao salvar(@Valid @RequestBody Organizacao organizacao) {
        return service.salvar(organizacao);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}