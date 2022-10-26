package com.cvr.crudcliente.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvr.crudcliente.entity.Cliente;
import com.cvr.crudcliente.repository.ClienteRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepositorio repositorio;
	
	public ArrayList<Cliente>obtenerClientes(){
		return (ArrayList<Cliente>) repositorio.findAll();
	}
	
	public Cliente guardarCliente(Cliente cliente){
		return repositorio.save(cliente);
	}

	public void eliminarCliente(Long id){
		Cliente cliente = repositorio.findById(id).get();
		repositorio.delete(cliente);
	}
	
	public Cliente actualizarCliente(Cliente cliente){
		Cliente clienteUpd = repositorio.findById(cliente.getId()).get();
		clienteUpd.setNombre(cliente.getNombre());
		clienteUpd.setRut(cliente.getRut());
		clienteUpd.setCorreo(cliente.getCorreo());
		return repositorio.save(clienteUpd);
	}

}
