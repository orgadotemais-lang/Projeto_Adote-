package br.edu.unifio.ecommerce.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unifio.ecommerce.entidades.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.status = :status")
    List<Animal> buscarPorStatus(@Param("status") String status);

}