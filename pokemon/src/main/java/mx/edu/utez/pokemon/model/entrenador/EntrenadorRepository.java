package mx.edu.utez.pokemon.model.entrenador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

    boolean existsEnByNombre(String nombre);
}
