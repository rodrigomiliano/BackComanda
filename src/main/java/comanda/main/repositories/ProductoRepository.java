package comanda.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comanda.main.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {}
