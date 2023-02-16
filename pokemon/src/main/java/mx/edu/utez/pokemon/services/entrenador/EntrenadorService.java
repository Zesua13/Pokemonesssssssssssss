package mx.edu.utez.pokemon.services.entrenador;

import mx.edu.utez.pokemon.model.entrenador.Entrenador;
import mx.edu.utez.pokemon.model.entrenador.EntrenadorRepository;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository Repository;
    @Transactional(readOnly = true)
    public Response<List<Entrenador>> getAll(){
        return new Response<>(
                this.Repository.findAll(), false, 200, "OK"
        );
    }

    //GET ONE
    @Transactional(readOnly = true)
    public Response<Entrenador> getOne(Long id){
        return new Response<>(
                this.Repository.findById(id).get(), false, 200, "OK"
        );
    }
    //INSERT
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> insert(Entrenador entrenador){
        if(this.Repository.existsEnByNombre(entrenador.getNombre())){
            return new Response<>(null,true,400,"ya esta registrado");
        }
        return new Response<>(
                this.Repository.saveAndFlush(entrenador),false,200,"OK"
        );
    }


    //UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> update(Long id,Entrenador entrenador) {
        if ((!this.Repository.existsById(id))) {
            return new Response<>(null, true, 400, "Producto inexistente");
        }
        return new Response<>(
                this.Repository.saveAndFlush(entrenador), false, 200, "OK"
        );

    }
   @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> delete(Long id){
        Optional<Entrenador> exists = this.Repository.findById(id);

        if((!exists.isPresent())){
            return new Response<>(null,true,400,"inexistente");
        }
        this.Repository.deleteById(id);
        return new Response<>(
                null,false,200,"OK"
        );
    }
}
