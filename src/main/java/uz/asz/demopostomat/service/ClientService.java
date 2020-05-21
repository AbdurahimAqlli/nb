package uz.asz.demopostomat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.asz.demopostomat.entity.Client;
import uz.asz.demopostomat.entity.Item;
import uz.asz.demopostomat.repository.ClientRepository;
import uz.asz.demopostomat.repository.ItemRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    public void createClient(String location, String fullname, Integer purchased_id, String postomatName) {
        Client client = new Client();
        client.setLocation(location);
        client.setFullname(fullname);
        Item item = new Item();
        Optional<Item> optionalItem = itemRepository.findById(purchased_id);
        item.setName(optionalItem.get().getName());
        item.setId(optionalItem.get().getId());
        client.setItem(item);
        client.setPostomatName(postomatName);
        repository.save(client);
    }
}
