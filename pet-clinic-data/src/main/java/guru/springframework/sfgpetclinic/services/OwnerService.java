package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);

    Set<Owner> findAll();

    Owner save(Owner owner);

    Owner findByLastname(String lastName);
}
