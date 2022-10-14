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

import comanda.main.dtos.EtiquetaDTO;
import comanda.main.exceptions.StatusException;
import comanda.main.services.EtiquetaService;

/*@Controller*/
@RestController
/*@RequestMapping(path = "comanda/v1/etiquetas")*/
public class EtiquetaController extends ComandaApp implements ObjectController<EtiquetaDTO>{

	private EtiquetaService etiquetaService;
	
	public EtiquetaController(EtiquetaService etiquetaService) {
		this.etiquetaService = etiquetaService;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@Override
	@GetMapping(path = "/v1/etiquetas")
	public List<EtiquetaDTO> getAll() {
		
		return ResponseEntity.status(200).body(etiquetaService.getAll()).getBody();
		
	}

	@Override
	@GetMapping(path = "//v1/etiquetas/{id}")
	public EtiquetaDTO getOne(@PathVariable int id) {
		
		return ResponseEntity.status(200).body(etiquetaService.getOne(id)).getBody();
		
	}

	@Override
	@PostMapping(path = "/v1/etiquetas")
	public ResponseEntity save(@RequestBody EtiquetaDTO t) {
		
		EtiquetaDTO temp = etiquetaService.save(t);		
		
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
	@PutMapping(path = "/v1/etiquetas/{id}")
	public ResponseEntity update(@RequestBody EtiquetaDTO t, @PathVariable int id) {
		
		EtiquetaDTO temp = etiquetaService.update(t, id);
		
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
	@DeleteMapping(path = "/v1/etiquetas/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		boolean det = etiquetaService.delete(id);
		
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
