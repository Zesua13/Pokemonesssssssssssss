package mx.edu.utez.pokemon.controllers.entrenadores;

import mx.edu.utez.pokemon.controllers.entrenadores.dtos.EntrenadorDto;
import mx.edu.utez.pokemon.model.entrenador.Entrenador;
import mx.edu.utez.pokemon.services.entrenador.EntrenadorService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api-pokemon/entrenador")
@CrossOrigin(origins = {"*"})
public class EntrenadorController {
    @Autowired
    private EntrenadorService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenador>>>getAll(){
        return new ResponseEntity<> (this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenador>>getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Response<Entrenador>> insert(@Valid @RequestBody EntrenadorDto entrenador){
        return new ResponseEntity<> (
                this.service.insert(entrenador.getEntrenador()),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> update(@PathVariable Long id, @Valid @RequestBody EntrenadorDto entrenador){
        return new ResponseEntity<>(
                this.service.update(id, entrenador.getEntrenador()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
