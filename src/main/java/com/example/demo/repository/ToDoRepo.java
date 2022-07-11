package com.example.demo.repository;


import com.example.demo.entity.ToDoEntity;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
