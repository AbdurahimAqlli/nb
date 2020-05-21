package uz.asz.demopostomat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.asz.demopostomat.entity.Courier;
import uz.asz.demopostomat.repository.CourierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {
    @Autowired
    private CourierRepository courierRepository;
    public void changeCourierStatus(Integer id,Boolean status){
        Optional<Courier> courier=courierRepository.findById(id);
        if (courier.isPresent()){
           courier.get().setStatus(status);
           courier.get().setId(id);
            courierRepository.save(courier.get());
        }
    }
    public List<Courier> getCourier(){
        List<Courier> couriers=courierRepository.findAllByStatusTrue();
        return couriers;
    }
}
