package com.softtek.BitFest.servicio.Implementacion;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IOrganizadorRepositorio;
import com.softtek.BitFest.servicio.IOrganizadorServicio;
import org.springframework.beans.factory.annotation.Autowired;

public class OrganizadorImpl  extends CRUDImpl<Organizador, Integer> implements IOrganizadorServicio {

    @Autowired
    private IOrganizadorRepositorio organizadorRepo;

    @Override
    protected IGenericoRepositorio<Organizador, Integer> getRepo() {
        return organizadorRepo;
    }
}
