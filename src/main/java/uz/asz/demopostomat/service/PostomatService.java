package uz.asz.demopostomat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.asz.demopostomat.entity.Postomat;
import uz.asz.demopostomat.repository.PostomatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostomatService {
    @Autowired
    private PostomatRepository postomatRepository;

    public void createPostomat(String name, String location) {
        Postomat postomat = new Postomat();
        postomat.setName(name);
        postomat.setLocation(location);
        postomat.setStatus(false);
        postomatRepository.save(postomat);
    }

    public void changePostomatStatus(Integer id, Boolean status) {
        Optional<Postomat> postomat = postomatRepository.findById(id);
        if (postomat.isPresent()) {
            postomat.get().setStatus(status);
            postomatRepository.save(postomat.get());
        }
    }

    public List<Postomat> getAllPostomats() {
        return postomatRepository.findAll();
    }
}
