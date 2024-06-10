package com.softtek.BitFest.Controlador;

import com.softtek.BitFest.Excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.BitFest.dto.OrganizadorDTO;
import com.softtek.BitFest.dto.OrganizadorInformacionDTO;
import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/auth/organizadores")
@CrossOrigin(origins = "http://localhost:4200")

public class ControladorOrganizador {
    @Autowired
    private IOrganizadorServicio servicio;

    @GetMapping
    public ResponseEntity<List<OrganizadorDTO>> obtenerTodos() {
        List<Organizador> organizadoresBBDD = servicio.consultarTodos();
        List<OrganizadorDTO> organizadoresDTO = new ArrayList<>();
        for (Organizador elemento : organizadoresBBDD) {
            OrganizadorDTO eDto = new OrganizadorDTO();
            organizadoresDTO.add(eDto.castDto(elemento));
        }
        return new ResponseEntity<>(organizadoresDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorInformacionDTO> obtenerId(@PathVariable(name = "id") Integer id) {
        Organizador organizador = servicio.consultarUno(id);
        if (organizador == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("Organizador no encontrado " + id);
        }
        return new ResponseEntity<>((new OrganizadorInformacionDTO()).castDto(organizador), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Organizador> insertarOrganizador(@RequestBody Organizador organizador) {
        return new ResponseEntity<>(servicio.crear(organizador), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Organizador> actualizarOrganizador(@RequestBody Organizador organizador) {
        return new ResponseEntity<>(servicio.modificar(organizador), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarOrganizador(@PathVariable("id") int id) {
        if(servicio.consultarUno(id)!=null) {
            servicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ExcepcionPersonalizadaNoEncontrado("Organizador con id  " + id +" no encontrado");
        }
    } @GetMapping("/7primerosOrganizador")
    public ResponseEntity<List<OrganizadorDTO>> findTop7OrganizersByName(){
        List<Organizador> organizadores = servicio.findTop7OrganizersByName();
        List<OrganizadorDTO> organizadoresDTO = new ArrayList<>();
        for (Organizador organizador : organizadores) {
            OrganizadorDTO dto = new OrganizadorDTO();
            organizadoresDTO.add(dto.castDto(organizador));
        }
        return new ResponseEntity<>(organizadoresDTO, HttpStatus.OK);
    }

    @GetMapping("/porOrganizadorLike")
    public ResponseEntity<List<OrganizadorDTO>> findByNombreLike(@RequestParam(name="nombre") String nombre){
        List<Organizador> organizadores = servicio.findByNombreLike(nombre);
        List<OrganizadorDTO> organizadoresDTO = new ArrayList<>();
        for (Organizador organizador : organizadores) {
            OrganizadorDTO dto = new OrganizadorDTO();
            organizadoresDTO.add(dto.castDto(organizador));
        }
        return new ResponseEntity<>(organizadoresDTO, HttpStatus.OK);
    }

}