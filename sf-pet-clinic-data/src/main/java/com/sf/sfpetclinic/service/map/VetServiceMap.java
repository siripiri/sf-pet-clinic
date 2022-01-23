package com.sf.sfpetclinic.service.map;

import com.sf.sfpetclinic.Model.Vet;
import com.sf.sfpetclinic.service.CrudServices;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudServices<Vet, Long> {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
