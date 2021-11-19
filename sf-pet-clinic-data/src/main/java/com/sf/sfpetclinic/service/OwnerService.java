package com.sf.sfpetclinic.service;

import com.sf.sfpetclinic.Model.Owner;

import java.util.Set;

public interface OwnerService extends CrudServices<Owner,Long> {

    Owner findByLastname(String lastname);

}
