package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activos);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);

    public Articulo getArticulo(Articulo articulo);
    
    public List<Articulo> getPorExistencias(int existencias);
    
    public List<Articulo> getPorExistenciasCategorias(int existencias,Long idCategorias);
}
