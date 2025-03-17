package br.com.smartlist.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartlist.app.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping
    public List<Item> getAllItems(){
        return getAllItems();
    }

    @PostMapping
    public Item createItem(@RequestBody Item items){
        return items;
    }
    
    @PutMapping
    public Item updaItem(@PathVariable Long id, @RequestBody Item item){
        return item;
    }

 //   @DeleteMapping("/{id}")
 //   public void Item deleteItem(@PathVariable Long id){
        
  //  }

}
