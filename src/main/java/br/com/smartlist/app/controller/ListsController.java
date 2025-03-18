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
    public Lists createLists(@RequestBody Lists lists){
        return listsRepository.save(lists);
    }

    @PutMapping("upadate_lists/{id}")
    public Lists updateLists(@PathVariable Long id, @RequestBody Lists lists){
        Lists existengLists = listsRepository.findById(null).orElseThrow();
        //existengLists.setName(Lists.getName());
        return listsRepository.save(existengLists);
    }

    @DeleteMapping("delete_lists/{id}")
    public void deleteShoppingList(@PathVariable Long id) {
        listsRepository.deleteById(id);
    }

}
