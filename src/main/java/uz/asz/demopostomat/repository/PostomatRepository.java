package uz.asz.demopostomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.asz.demopostomat.entity.Postomat;

@Repository
public interface PostomatRepository extends JpaRepository<Postomat,Integer> {

}
