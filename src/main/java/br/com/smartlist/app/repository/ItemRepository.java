package br.com.smartlist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smartlist.app.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    
}