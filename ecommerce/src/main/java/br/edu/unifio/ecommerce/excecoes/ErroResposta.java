package br.edu.unifio.ecommerce.excecoes;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroResposta {

    private LocalDateTime data;
    private int status;
    private String mensagem;

    public ErroResposta(int status, String mensagem) {
        this.data = LocalDateTime.now();
        this.status = status;
        this.mensagem = mensagem;
    }
}
