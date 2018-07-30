package hello.service;

import hello.model.Owner;
import hello.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findAll() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findById(Long pId) {
        return  ownerRepository.findById(pId);
    }

    @Override
    public void addOwner(Owner pOwner) {
        ownerRepository.save(pOwner);
    }

    @Override
    public void deleteById(Long pId) {
        ownerRepository.deleteById(pId);
    }

    @Override
    public void deleteOwner(Owner pOwner) {
        ownerRepository.delete(pOwner);
    }
}
