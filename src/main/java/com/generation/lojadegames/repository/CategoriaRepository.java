package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojadegames.model.CategoriaModel;


public interface CategoriaRepository extends JpaRepository <CategoriaModel, Long>{

	public List <CategoriaModel>  findAllByDescricaoContainingIgnoreCase(String descricao);
}
