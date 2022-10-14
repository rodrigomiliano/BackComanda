package comanda.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comanda.main.entities.Etiqueta;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {}
