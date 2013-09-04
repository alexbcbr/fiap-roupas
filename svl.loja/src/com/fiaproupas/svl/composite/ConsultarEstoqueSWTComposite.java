package com.fiaproupas.svl.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Consulta todos os produtos em estoque
 * @author alexbc
 * @version 1.0
 */
public class ConsultarEstoqueSWTComposite extends Group {
	
	/** tabela com a lista de produtos em estoque */
	private Table table;

	/**
	 * Montagem da tela composto.
	 *
	 * @param parent janela parente
	 * @param style estilo da janela que será aberta
	 */
	public ConsultarEstoqueSWTComposite(Composite parent, int style) {
		super(parent, style);
		
		Button btnFazerPesquisaEstoque = new Button(this, SWT.NONE);
		btnFazerPesquisaEstoque.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(table, 0);
				item.setText(new String[] { "Calca", "10 unidades" });
				
				TableItem item2 = new TableItem(table, 1);
				item2.setText(new String[] { "Camisa", "20 unidades" });

			}
		});
		btnFazerPesquisaEstoque.setBounds(144, 29, 148, 35);
		btnFazerPesquisaEstoque.setText("Fazer Pesquisa Estoque");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 86, 409, 164);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnDescricao = new TableColumn(table, SWT.NONE);
		tblclmnDescricao.setWidth(223);
		tblclmnDescricao.setText("Descricao");
		
		TableColumn tblclmnQuantidadeEmEstoque = new TableColumn(table, SWT.NONE);
		tblclmnQuantidadeEmEstoque.setWidth(136);
		tblclmnQuantidadeEmEstoque.setText("Quantidade em Estoque");

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Group#checkSubclass()
	 */
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
