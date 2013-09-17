/**
 * 
 */
function pesquisar(){

	var codProduto = document.getElementById("txtCodigoProduto").value;
	if (codProduto == 1)
		document.getElementById("txtDescricao").value="Calca";
	else
		document.getElementById("txtDescricao").value="Blusa";

}
