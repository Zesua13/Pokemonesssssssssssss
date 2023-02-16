package mx.edu.utez.pokemon.model.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    boolean existsEnByNombre(String nombre);
}
