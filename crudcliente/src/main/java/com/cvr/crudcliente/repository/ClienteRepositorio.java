package com.cvr.crudcliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cvr.crudcliente.entity.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

	
	
}