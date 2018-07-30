package hello.service;

import hello.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> findAll();

    Optional<Owner> findById(Long pId);

    void addOwner(Owner pOwner);

    void deleteById(Long pId);

    void deleteOwner(Owner pOwner);

}
