package comanda.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comanda.main.dtos.CategoriaDTO;
import comanda.main.entities.Categoria;
import comanda.main.repositories.CategoriaRepository;

@Service
/*Esta interfaz nos indica que métodos hay que usar (getNombre, getDesc)*/
public class CategoriaService implements ObjectService<CategoriaDTO> {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public List<CategoriaDTO> getAll() {
		
		List<CategoriaDTO> result = new ArrayList<>();
		
		for(Categoria categoria : categoriaRepository.findAll())/*trae todos los datos y los inyecta en un array*/ {
			CategoriaDTO temp = new CategoriaDTO();
			temp.setId(categoria.getId());
			temp.setNombre(categoria.getNombre());
			temp.setDescripcion(categoria.getDescripcion());			
			result.add(temp);
		}
		
		return result;
		
	}

	@Override
	public CategoriaDTO getOne(int id) {
		
		Optional<Categoria> aOptional = categoriaRepository.findById(id);/*Puede devolver o no un objeto del tipo Categoria*/
		
		CategoriaDTO temp = new CategoriaDTO();
		
		try {
			
			Categoria categoria = aOptional.get();
			temp.setId(categoria.getId());
			temp.setNombre(categoria.getNombre());
			temp.setDescripcion(categoria.getDescripcion());			
			
		} catch (Exception e) {

			System.out.println("No existe el id");
			
		}
		
		return temp;
		
	}

	@Override
	public CategoriaDTO save(CategoriaDTO t) {
		
		Categoria categoria = new Categoria();
		
		categoria.setNombre(t.getNombre());
		categoria.setDescripcion(t.getDescripcion());
				
		try {
			
			categoriaRepository.save(categoria);
			
		} catch (Exception e) {
			
			System.out.println("Bad Request");
			
		}
		
		t.setId(categoria.getId());
		
		return t;
		
	}

	@Override
	public CategoriaDTO update(CategoriaDTO t, int id) {
		
		Optional<Categoria> pOptional = categoriaRepository.findById(id);
		
		Categoria temp = new Categoria();
		
		try {
			
			temp = pOptional.get();			
			temp.setNombre(t.getNombre());
			temp.setDescripcion(t.getDescripcion());
			
			
			categoriaRepository.save(temp);
			t.setId(temp.getId());
			
			
		} catch (Exception e) {
			
			System.out.println("Bad Request");
			t.setId(0);
			
		}
		
		return t;
		
	}

	@Override
	public boolean delete(int id) {
		
		try {
			
			categoriaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}
	
}
