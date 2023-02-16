package mx.edu.utez.pokemon.model.entrenador;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Entrenadores")
@NoArgsConstructor
@Getter
@Setter
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "nombre", length = 150)
    private String nombre;
    @Column(nullable = false, name = "equipo", length = 150)
    private String equipo;

    public Entrenador(Long id, String nombre, String equipo) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
    }
}
