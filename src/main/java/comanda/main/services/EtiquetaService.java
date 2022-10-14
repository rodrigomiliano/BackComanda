package comanda.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comanda.main.dtos.EtiquetaDTO;
import comanda.main.entities.Etiqueta;
import comanda.main.repositories.EtiquetaRepository;

@Service
public class EtiquetaService implements ObjectService<EtiquetaDTO> {

	private EtiquetaRepository etiquetaRepository;
	
	public EtiquetaService(EtiquetaRepository etiquetaRepository) {
		this.etiquetaRepository = etiquetaRepository;
	}
	
	@Override
	public List<EtiquetaDTO> getAll() {
		
		List<EtiquetaDTO> result = new ArrayList<>();
		
		for(Etiqueta etiqueta : etiquetaRepository.findAll()) {
			EtiquetaDTO temp = new EtiquetaDTO();
			temp.setId(etiqueta.getId());
			temp.setNombre(etiqueta.getNombre());
			temp.setDescripcion(etiqueta.getDescripcion());			
			result.add(temp);
		}
		
		return result;
		
	}

	@Override
	public EtiquetaDTO getOne(int id) {
		
		Optional<Etiqueta> aOptional = etiquetaRepository.findById(id);
		
		EtiquetaDTO temp = new EtiquetaDTO();
		
		try {
			
			Etiqueta etiqueta = aOptional.get();
			temp.setId(etiqueta.getId());
			temp.setNombre(etiqueta.getNombre());
			temp.setDescripcion(etiqueta.getDescripcion());			
			
		} catch (Exception e) {

			System.out.println("No existe el id");
			
		}
		
		return temp;
		
	}

	@Override
	public EtiquetaDTO save(EtiquetaDTO t) {
		
		Etiqueta etiqueta = new Etiqueta();
		
		etiqueta.setNombre(t.getNombre());
		etiqueta.setDescripcion(t.getDescripcion());
				
		try {
			
			etiquetaRepository.save(etiqueta);
			
		} catch (Exception e) {
			
			System.out.println("Bad Request");
			
		}
		
		t.setId(etiqueta.getId());
		
		return t;
		
	}

	@Override
	public EtiquetaDTO update(EtiquetaDTO t, int id) {
		
		Optional<Etiqueta> pOptional = etiquetaRepository.findById(id);
		
		Etiqueta temp = new Etiqueta();
		
		try {
			
			temp = pOptional.get();			
			temp.setNombre(t.getNombre());
			temp.setDescripcion(t.getDescripcion());
			
			
			etiquetaRepository.save(temp);
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
			
			etiquetaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}
	
}
