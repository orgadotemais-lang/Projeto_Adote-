package br.edu.unifio.ecommerce.controladores;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.unifio.ecommerce.entidades.Solicitacao;
import br.edu.unifio.ecommerce.servicos.SolicitacaoService;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoService service;

    public SolicitacaoController(SolicitacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Solicitacao> listar() {
        return service.listar();
    }

    @GetMapping("/status/{status}")
    public List<Solicitacao> buscarPorStatus(@PathVariable String status) {
        return service.buscarPorStatus(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Solicitacao salvar(@Valid @RequestBody Solicitacao solicitacao) {
        return service.salvar(solicitacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Solicitacao solicitacao) {

        return service.buscarPorId(id)
                .map(solicitacaoExistente -> {
                    solicitacao.setId(id);
                    return ResponseEntity.ok(service.salvar(solicitacao));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}