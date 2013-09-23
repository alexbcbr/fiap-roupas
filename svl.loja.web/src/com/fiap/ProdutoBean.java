package com.fiap;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="p")
@ViewScoped
public class ProdutoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8282248474444512701L;
	
	private PedidoTO pedido = new PedidoTO();
	
	public String btnPesquisarProd() {
		System.out.println("Action");
		
		if (pedido.getCodProduto() == 1) {
			pedido.setDescricao("Blusa");
			pedido.setPrecoUnitario(5);
		} else {
			pedido.setDescricao("Jaqueta");
			pedido.setPrecoUnitario(5);			
		}
		return "";
	}

	public PedidoTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoTO pedido) {
		this.pedido = pedido;
	}
	
}
