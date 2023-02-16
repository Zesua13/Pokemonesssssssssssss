package mx.edu.utez.pokemon.controllers.pokemones;

import mx.edu.utez.pokemon.controllers.entrenadores.dtos.EntrenadorDto;
import mx.edu.utez.pokemon.controllers.pokemones.dto.PokemonDto;
import mx.edu.utez.pokemon.model.pokemon.Pokemon;
import mx.edu.utez.pokemon.services.pokemon.PokemonService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api-pokemon/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<> (this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>> insert(@Valid @RequestBody PokemonDto pokemon){
        return new ResponseEntity<> (
                this.service.insert(pokemon.getPokemon()),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> update(@PathVariable Long id, @Valid @RequestBody PokemonDto pokemon){
        return new ResponseEntity<>(
                this.service.update(id, pokemon.getPokemon()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
