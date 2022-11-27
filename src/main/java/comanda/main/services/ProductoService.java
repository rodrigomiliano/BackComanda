package comanda.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comanda.main.dtos.ProductoDTO;
import comanda.main.entities.Categoria;
import comanda.main.entities.Producto;
import comanda.main.repositories.CategoriaRepository;
import comanda.main.repositories.ProductoRepository;

@Service
public class ProductoService implements ObjectService<ProductoDTO> {

	private ProductoRepository productoRepository;
	private CategoriaRepository categoriaRepository;
	
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	@Override
	public List<ProductoDTO> getAll() {
		
		List<ProductoDTO> result = new ArrayList<>();
		
		for(Producto producto : productoRepository.findAll()) {
			ProductoDTO temp = new ProductoDTO();
			temp.setId(producto.getId());
			temp.setNombre(producto.getNombre());
			temp.setDescripcion(producto.getDescripcion());
			temp.setPrecio(producto.getPrecio());		
			temp.setCategoriaId(producto.getCategoria());
			result.add(temp);
		}
		
		return result;
		
	}

	@Override
	public ProductoDTO getOne(int id) {
		
		Optional<Producto> aOptional = productoRepository.findById(id);
		
		ProductoDTO temp = new ProductoDTO();
		
		try {
			
			Producto producto = aOptional.get();
			temp.setId(producto.getId());
			temp.setNombre(producto.getNombre());
			temp.setDescripcion(producto.getDescripcion());
			temp.setPrecio(producto.getPrecio());		
			temp.setCategoriaId(producto.getCategoria());
		} catch (Exception e) {

			System.out.println("No existe el id");
			
		}
		
		return temp;
		
	}

	@Override
	public ProductoDTO save(ProductoDTO t) {
		
		Producto producto = new Producto();
		
		producto.setNombre(t.getNombre());
		producto.setDescripcion(t.getDescripcion());
		producto.setPrecio(t.getPrecio());
		Optional<Categoria> categoria = categoriaRepository.findById(t.getCategoriaId());
		if (categoria.isPresent()) {
			System.out.println("¿Entra?");
			producto.setCategoria(categoria.get());	
		}
		
				
		try {
			
			productoRepository.save(producto);
			
		} catch (Exception e) {
			
			System.out.println("Bad Request ProductoService");
			
		}
		
		t.setId(producto.getId());
		
		return t;
		
	}

	@Override
	public ProductoDTO update(ProductoDTO t, int id) {
		
		Optional<Producto> pOptional = productoRepository.findById(id);
		
		Producto temp = new Producto();
		
		try {
			
			temp = pOptional.get();			
			temp.setNombre(t.getNombre());
			temp.setDescripcion(t.getDescripcion());
			temp.setPrecio(t.getPrecio());
			
			
			productoRepository.save(temp);
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
			
			productoRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}
	
}
