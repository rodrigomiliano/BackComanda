package comanda.main.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comanda.main.dtos.CategoriaDTO;
import comanda.main.exceptions.StatusException;
import comanda.main.services.CategoriaService;

/*@Controller*/
@RestController
/*@RequestMapping(path = "comanda/v1/categorias")*/
public class CategoriaController extends ComandaApp implements ObjectController<CategoriaDTO>{

	private CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@Override
	@GetMapping(path = "/v1/categorias")
	public List<CategoriaDTO> getAll() {
		
		return ResponseEntity.status(200).body(categoriaService.getAll()).getBody();
		
	}

	@Override
	@GetMapping(path = "//v1/categorias/{id}")
	public CategoriaDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(categoriaService.getOne(id)).getBody();
		
	}

	@Override
	@PostMapping(path = "/v1/categorias")
	public ResponseEntity save(@RequestBody CategoriaDTO t) {
		
		CategoriaDTO temp = categoriaService.save(t);		
		
		try {
			
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
		
	}

	@Override
	@PutMapping(path = "/v1/categorias/{id}")
	public ResponseEntity update(@RequestBody CategoriaDTO t, @PathVariable int id) {
		
		CategoriaDTO temp = categoriaService.update(t, id);
		
		try {
			
			if(temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			}
			else {
				throw new StatusException("Bad request. Please check the values", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
		
	}

	@Override
	@DeleteMapping(path = "/v1/categorias/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		boolean det = categoriaService.delete(id);
		
		try {
			
			if(det) {
				return ResponseEntity.status(204).body("{ \"Succesful\": \"Correctly removed.\" }");
			}
			else {
				throw new StatusException("Bad request. Please verify the id", 400);
			}
			
		} catch (StatusException e) {
			
			return e.getResponseStatus();
			
		}
		
	}

	
	
}
