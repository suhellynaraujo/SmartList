package br.com.smartlist.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.smartlist.app.model.Lists;
import br.com.smartlist.app.repository.ListsRepository;

@RestController
@RequestMapping("/api/lists")
public class ListsController {

    @Autowired
    private ListsRepository listsRepository;

    @GetMapping("/all_lists")
    public List<Lists> getAllLists(){
        return listsRepository.findAll();
    }
    
    @PostMapping("/create_lists")
    public ResponseEntity<Lists> createLists(@RequestBody Lists lists){
        Lists savedList = listsRepository.save(lists);
        return new ResponseEntity<>(savedList, HttpStatus.CREATED);
    }

    @PutMapping("/update_lists/{id}")
    public Lists updateLists(@PathVariable Long id, @RequestBody Lists lists){
    Lists existingLists = listsRepository.findById(id).orElseThrow();
    existingLists.setName(lists.getName());
    existingLists.setTotalPrice(lists.getTotalPrice());
    existingLists.setTotalAvailable(lists.getTotalAvailable());
    return listsRepository.save(existingLists);
}


    @DeleteMapping("/delete_lists/{id}")
    public void deleteShoppingList(@PathVariable Long id) {
        listsRepository.deleteById(id);
    }

}
