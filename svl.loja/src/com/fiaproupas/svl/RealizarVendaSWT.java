package com.fiaproupas.svl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * Classe para realizar as vendas de produtos no sistema de Vendas de Lojas (SVL)
 * @author alexbc
 * @version 1.0
 */
public class RealizarVendaSWT {

	/** Abstra��o que representa a janela de top-level da aplica��o */
	protected Shell shlSvlSistema;
	
	/** Caixa de texto do campo codigo do produto */
	private Text txtCodProduto;
	
	/** Caixa de texto do campo quantidade do produto . */
	private Text txtQuantidade;
	
	/** Tabela com o resultado da pesquisa */
	private Table table;

	/**
	 * Launch da aplica��o
	 */
	public static void main(String[] args) {
		try {
			RealizarVendaSWT window = new RealizarVendaSWT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abrir janela
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlSvlSistema.open();
		shlSvlSistema.layout();
		while (!shlSvlSistema.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Monta componentes visuais que populam a Janela
	 */
	protected void createContents() {
		shlSvlSistema = new Shell();
		shlSvlSistema.setSize(714, 574);
		shlSvlSistema.setText("SVL - Sistema de Venda de Lojas");

		Menu menu = new Menu(shlSvlSistema, SWT.BAR);
		shlSvlSistema.setMenuBar(menu);

		MenuItem mntmOperacoesLoja = new MenuItem(menu, SWT.CASCADE);
		mntmOperacoesLoja.setText("Opera\u00E7\u00F5es Loja");

		Menu menu_1 = new Menu(mntmOperacoesLoja);
		mntmOperacoesLoja.setMenu(menu_1);

		MenuItem mntmAberturaDeLoja = new MenuItem(menu_1, SWT.NONE);
		mntmAberturaDeLoja.setText("Abertura de Loja");

		MenuItem mntmConcluirCompra = new MenuItem(menu_1, SWT.NONE);
		mntmConcluirCompra.setText("Concluir Compra");

		MenuItem mntmEncerramento = new MenuItem(menu, SWT.NONE);
		mntmEncerramento.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlSvlSistema.close();
			}
		});
		mntmEncerramento.setText("Encerramento");

		Group group = new Group(shlSvlSistema, SWT.NONE);
		group.setBounds(10, 10, 661, 101);

		Label lblCdigoDoProduto = new Label(group, SWT.NONE);
		lblCdigoDoProduto.setBounds(10, 22, 89, 13);
		lblCdigoDoProduto.setText("C\u00F3digo do Produto");

		txtCodProduto = new Text(group, SWT.BORDER);
		txtCodProduto.setBounds(124, 16, 76, 19);

		Label lblQuantidade = new Label(group, SWT.NONE);
		lblQuantidade.setBounds(10, 57, 56, 13);
		lblQuantidade.setText("Quantidade");

		txtQuantidade = new Text(group, SWT.BORDER);
		txtQuantidade.setBounds(124, 54, 76, 19);

		Button btnConfirmar = new Button(group, SWT.NONE);
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(table, 0);
				item.setText(new String[] { txtCodProduto.getText(), "Cal�a", txtQuantidade.getText() });

			}
		});
		btnConfirmar.setBounds(245, 22, 117, 23);
		btnConfirmar.setText("Confirmar Produto");			

		Group group_1 = new Group(shlSvlSistema, SWT.NONE);
		group_1.setBounds(10, 114, 661, 263);

		table = new Table(group_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(24, 28, 594, 211);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnCdigoDoProduto = new TableColumn(table, SWT.NONE);
		tblclmnCdigoDoProduto.setWidth(114);
		tblclmnCdigoDoProduto.setText("C\u00F3digo do Produto");

		TableColumn tblclmnDescrioDoProduto = new TableColumn(table, SWT.NONE);
		tblclmnDescrioDoProduto.setWidth(129);
		tblclmnDescrioDoProduto.setText("Descri\u00E7\u00E3o do Produto");

		TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");

		TableColumn tblclmnPreoUnitria = new TableColumn(table, SWT.NONE);
		tblclmnPreoUnitria.setWidth(100);
		tblclmnPreoUnitria.setText("Pre\u00E7o Unit\u00E1rio");

		TableColumn tblclmnPreoTotal = new TableColumn(table, SWT.NONE);
		tblclmnPreoTotal.setWidth(152);
		tblclmnPreoTotal.setText("Pre\u00E7o Total");

		Group group_2 = new Group(shlSvlSistema, SWT.NONE);
		group_2.setBounds(10, 383, 661, 50);

		Button btnFecharPedido = new Button(group_2, SWT.NONE);
		btnFecharPedido.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox mb = new MessageBox(shlSvlSistema, SWT.YES | SWT.NO);
				mb.setText("Fechamento do Pedido");
				mb.setMessage("Confirma Conclus�o do Pedido");
				int val = mb.open();
				String valString = "";
				switch (val) // val contains the constant of the selected button
				{
				case SWT.YES:
					valString = "SWT.YES";
					break;
				case SWT.NO:
					valString = "SWT.NO";
					break;
				}
			}
		});
		btnFecharPedido.setBounds(289, 17, 118, 23);
		btnFecharPedido.setText("Fechar Pedido");

		Button btnCancelaPedido = new Button(group_2, SWT.NONE);
		btnCancelaPedido.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
			}
		});
		btnCancelaPedido.setText("Cancela Pedido");
		btnCancelaPedido.setBounds(476, 17, 118, 23);

		Button btnExcluiProduto = new Button(group_2, SWT.NONE);
		btnExcluiProduto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (table.getSelectionIndex() >= 0)
					table.remove(table.getSelectionIndex());
			}
		});
		btnExcluiProduto.setText("Exclui Produto");
		btnExcluiProduto.setBounds(103, 17, 118, 23);

	}
}
