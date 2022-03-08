package com.generation.lojadegames.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** @NotBlank
	@Size(min = 4, max = 255)
	private String name;
	
	@NotBlank
	@Size(min = 4, max = 550)
	private String description;
	
	@NotBlank
	@Size(min = 4, max = 60)
	private String console;
	
	private long quantity;
	**/
	
	@NotNull(message = "Nome é obrigatório!")                                       										
	private String nome;
	
	@Size(max=500)
	private String descricao;
	
	@NotNull(message = "Console é obrigatório!")
	private String console;
	
	private int quantidade;
	
	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Preço é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	private String foto;
	
	
	@ManyToOne //relação chave estrangeira
	@JsonIgnoreProperties("produto") // ignora. Não escreve o produto 2x
	private CategoriaModel categoria;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescription() {
		return descricao;
	}

	public void setDescription(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public long getQuantity() {
		return quantidade;
	}

	public void setQuantity(int quantidade) {
		this.quantidade = quantidade;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
}
