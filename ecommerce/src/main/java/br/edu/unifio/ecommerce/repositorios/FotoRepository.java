package br.edu.unifio.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.ecommerce.entidades.Foto;

public interface FotoRepository extends JpaRepository<Foto, Integer> {

}