package comanda.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comanda.main.entities.Categoria;

@Repository
/*Es basiacmente un DAO, nos ahorra de hacer las querys manualmente. JPA administra la persistencia a base de datos con Spring*/
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {}
