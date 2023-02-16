package mx.edu.utez.pokemon.controllers.entrenadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.entrenador.Entrenador;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EntrenadorDto {
    private Long id;
    private String nombre;
    private String equipo;


    public Entrenador getEntrenador(){
        return new Entrenador(
          getId(),
          getNombre(),
          getEquipo()
        );
    }

}
