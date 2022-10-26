package com.cvr.crudcliente.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvr.crudcliente.entity.Cliente;
import com.cvr.crudcliente.repository.ClienteRepositorio;
import com.cvr.crudcliente.services.ClienteService;
import com.cvr.crudcliente.util.Valida;

@RestController
@RequestMapping("/")
public class ClienteController {

	@Autowired
	ClienteService servicio;
	
	@Autowired
	ClienteRepositorio repositorio;
	
	@GetMapping("/ObtenerClientes")
	public ArrayList<Cliente> obtenerClientes() {
		return this.servicio.obtenerClientes();
	}

	@PostMapping("/guardarCliente")
	public ResponseEntity<Object> guardarCliente(@RequestBody Cliente cliente) {

		Valida valida = new Valida();
		
		if(valida.validaRutExistente(cliente.getRut())) {
			return errorResponse(HttpStatus.BAD_REQUEST, "El rut ya se encuentra registrado");
		}
		
		if(valida.validaCorreoUnico(cliente.getCorreo())) {
			return errorResponse(HttpStatus.BAD_REQUEST, "El correo ya se encuentra registrado");
		}

		this.servicio.guardarCliente(cliente);
		return new ResponseEntity("Registro exitoso", HttpStatus.OK);
		
	}
	
	@GetMapping("/eliminarCliente/{id}")
	public ResponseEntity<Object> EliminarCliente(@PathVariable(name="id") Long id){
		this.servicio.eliminarCliente(id);
		return new ResponseEntity("Registro eliminado correctamente", HttpStatus.OK);
	}
	
    private ResponseEntity<Object> errorResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(message);
    }
    
	@PostMapping("/actualizarCliente")
	public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cliente) {

		Valida valida = new Valida();
		
		if(valida.validaCorreoUnico(cliente.getCorreo())) {
			return errorResponse(HttpStatus.BAD_REQUEST, "El correo ya pertenece a otro usuario");
		}

		this.servicio.actualizarCliente(cliente);
		return new ResponseEntity("Registro actualizado correctamente", HttpStatus.OK);
		
	}

}
