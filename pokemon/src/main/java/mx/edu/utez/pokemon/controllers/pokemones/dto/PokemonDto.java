package mx.edu.utez.pokemon.controllers.pokemones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.entrenador.Entrenador;
import mx.edu.utez.pokemon.model.pokemon.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PokemonDto {
    private Long id;
    private String nombre;
    private String tipo;
    private int nivel;
    private int puntos;
    private int ataque;
    private int defensa;
    private int poder;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getNombre(),
                getTipo(),
                getPoder(),
                getPuntos(),
                getDefensa(),
                getAtaque()
        );
    }


}
