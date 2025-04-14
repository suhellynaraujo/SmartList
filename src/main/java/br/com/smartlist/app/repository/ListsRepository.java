package br.com.smartlist.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smartlist.app.model.Item;
import br.com.smartlist.app.model.Lists;

@Repository
public interface ListsRepository extends JpaRepository <Lists, Long>{

     List<Lists> findByItems_IdAndNameContainingIgnoreCase(Long listaId, String name);
    
}
