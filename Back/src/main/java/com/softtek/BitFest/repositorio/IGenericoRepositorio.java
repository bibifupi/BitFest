package com.softtek.BitFest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericoRepositorio<T,ID> extends JpaRepository<T, ID> {
}
