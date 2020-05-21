package uz.asz.demopostomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.asz.demopostomat.entity.Courier;

import java.util.List;

@Repository
public interface CourierRepository extends JpaRepository<Courier,Integer> {
    List<Courier> findAllByStatusTrue();
}
