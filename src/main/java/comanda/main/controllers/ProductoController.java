package comanda.main.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comanda.main.dtos.ProductoDTO;
import comanda.main.exceptions.StatusException;
import comanda.main.services.ProductoService;

/*@Controller*/
@RestController
/*@RequestMapping(path = "comanda/v1/productos")*/
public class ProductoController extends ComandaApp implements ObjectController<ProductoDTO>{

	private ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	
	@Override
	@GetMapping(path = "/v1/productos")
	public List<ProductoDTO> getAll() {
		
		return ResponseEntity.status(200).body(productoService.getAll()).getBody();
		
	}

	@Override
	@GetMapping(path = "//v1/productos/{id}")
	public ProductoDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(productoService.getOne(id)).getBody();
		
	}

	@Override
	@PostMapping(path = "/v1/productos")
	public ResponseEntity save(@RequestBody ProductoDTO t) {
		
		ProductoDTO temp = productoService.save(t);		
		
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
	@PutMapping(path = "/v1/productos/{id}")
	public ResponseEntity update(@RequestBody ProductoDTO t, @PathVariable int id) {
		
		ProductoDTO temp = productoService.update(t, id);
		
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
	@DeleteMapping(path = "/v1/productos/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		boolean det = productoService.delete(id);
		
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
