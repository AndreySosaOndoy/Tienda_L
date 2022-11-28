
package com.tienda.dao;


import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
    List<Articulo> findByExistencias(int existencias);
    
    List<Articulo> findByExistenciasOrIdCategoria(int existencias,Long idCategoria);
}
