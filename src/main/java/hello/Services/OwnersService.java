package hello.Services;

import hello.Models.Owners;
import hello.Repositorys.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnersService {

    @Autowired
    private OwnersRepository ownerRepository;

    public List<Owners> findAll() {
        return ownerRepository.findAll();
    }

    public Optional<Owners> findById(Long pId){
        return  ownerRepository.findById(pId);
    }

    public void addOwner(Owners pOwner){
        ownerRepository.save(pOwner);
    }

    public void deleteById(Long pId){
        ownerRepository.deleteById(pId);
    }

    public void deleteOwner(Owners pOwner){
        ownerRepository.delete(pOwner);
    }

    public void deleteAll(){
        ownerRepository.deleteAll();
    }
}
