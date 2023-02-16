package mx.edu.utez.pokemon.model.pokemon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Pokemon")
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "nombre", length = 150)
    private String nombre;
    @Column(nullable = false, name = "tipo", length = 150)
    private String tipo;
    @Column(nullable = false, name = "poder", length = 150)
    private int poder;
    @Column(nullable = false, name = "puntos", length = 150)
    private int puntos;
    @Column(nullable = false, name = "ataque", length = 150)
    private int ataque;
    @Column(nullable = false, name = "defensa", length = 150)
    private int defensa;

    public Pokemon(Long id, String nombre, String tipo, int poder, int puntos, int ataque, int defensa) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
        this.puntos = puntos;
        this.ataque = ataque;
        this.defensa = defensa;
    }

}
