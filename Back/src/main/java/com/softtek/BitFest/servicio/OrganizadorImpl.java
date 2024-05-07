package com.softtek.BitFest.servicio;

import com.softtek.BitFest.modelo.Organizador;
import com.softtek.BitFest.repositorio.ICategoriaRepositorio;
import com.softtek.BitFest.repositorio.IGenericoRepositorio;
import com.softtek.BitFest.repositorio.IOrganizadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizadorImpl extends CRUDImpl<Organizador, Integer> implements IOrganizadorServicio {
    @Autowired
    private IOrganizadorRepositorio orgRepo;

    @Override
    protected IGenericoRepositorio<Organizador, Integer> getRepo() {
        return orgRepo;
    }
}
