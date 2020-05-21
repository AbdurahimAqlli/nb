package uz.asz.demopostomat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.asz.demopostomat.entity.Item;
import uz.asz.demopostomat.entity.Postomat;
import uz.asz.demopostomat.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {
@Autowired
private  ItemRepository itemRepository;
    public void createItem(String name) {
        Item item=new Item();
        item.setName(name);
        itemRepository.save(item);
    }
    public List<Item> getItemById(Integer item) {
        List<Item> items = itemRepository.findAllById(Integer.valueOf(item));
    return items;
    }
    public List<Item> getAllItems(){
        List<Item> items=itemRepository.findAll();
        return items;
    }

}
