package com.sf.sfpetclinic.service;

import java.util.Set;

public interface CrudServices<T, ID>{

    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
