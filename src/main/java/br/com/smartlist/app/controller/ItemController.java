package br.com.smartlist.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartlist.app.model.Item;
import br.com.smartlist.app.model.Lists;
import br.com.smartlist.app.repository.ItemRepository;
import br.com.smartlist.app.repository.ListsRepository;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListsRepository listsRepository;

    @GetMapping("/all_items")
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @PostMapping("/create_items")
    public Item createItem(@RequestBody Item items){
        Lists lists = listsRepository.findById(items.getlists().getId()).orElseThrow();
        items.setlists(lists);
        return itemRepository.save(items);
    }
    
    @PutMapping("update_items/{id}")
    public Item updaItem(@PathVariable Long id, @RequestBody Item items){
        Item existingItems = itemRepository.findById(id).orElseThrow();
        existingItems.setName(items.getName());
        existingItems.setPrice(items.getPrice());
        existingItems.setQuantity(items.getQuantity());
        return itemRepository.save(existingItems);
    }

    @DeleteMapping("delete_items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}
