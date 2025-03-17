package br.com.smartlist.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.smartlist.app.model.Lists;

@Repository
public interface ListsRepository extends JpaRepository <Lists, Long>{
    
}
