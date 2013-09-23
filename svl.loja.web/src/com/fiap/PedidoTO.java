package com.fiap;

import java.io.Serializable;


public class PedidoTO implements Serializable{
	
	private static final long serialVersionUID = 962261074736327959L;
	
	private int codProduto;
	private String descricao;
	private int precoUnitario;
	
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(int precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getFoto() {
		return descricao + ".jpg";
	}

}
