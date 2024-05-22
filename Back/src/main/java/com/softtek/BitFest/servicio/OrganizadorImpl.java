package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.repositorio.ICategoriaRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IOrganizadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorImpl extends CRUDImpl<Organizador, Integer> implements IOrganizadorServicio {
    @Autowired
    private IOrganizadorRepositorio orgRepo;

    @Override
    protected IGenericoRepositorio<Organizador, Integer> getRepo() {
        return orgRepo;
    }

    @Override
    public List<Organizador> findByNombreAsc(String nombre) {
        return orgRepo.findByNombreAsc(nombre);
    }

    @Override
    public List<Organizador> findFirst6ByNombre(String nombre) {
        return orgRepo.findFirst6ByNombre(nombre);
    }

    @Override
    public List<Organizador> findByNombreLike(String nombre) {
        return orgRepo.findByNombreLike(nombre);
    }
}
