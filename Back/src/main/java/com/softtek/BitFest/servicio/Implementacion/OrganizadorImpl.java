package com.softtek.BitFest.servicio.Implementacion;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IOrganizadorRepositorio;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorImpl  extends CRUDImpl<Organizador, Integer> implements IOrganizadorServicio {

    @Autowired
    private IOrganizadorRepositorio organizadorRepo;

    @Override
    protected IGenericoRepositorio<Organizador, Integer> getRepo() {
        return organizadorRepo;
    }

    @Override
    public List<Organizador> findTop7OrganizersByName() {
        return organizadorRepo.findTop7OrganizersByName();
    }

    @Override
    public List<Organizador> findByNombreLike(String nombre) {
        String nombreBuscar = "%" + nombre + "%";
        return organizadorRepo.findByNombreLike(nombreBuscar);
    }
}