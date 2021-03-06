package com.fiaproupas.svl.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Consultar Preco
 * @author alexbc
 * @version 1.0
 */
public class ConsultarPrecoSWTComposite extends Group {
	
	/** Caixa de texto do campo codigo do produto */
	private Text txtCodProduto;
	
	/** Caixa de texto do campo quantidade do produto . */
	private Text txtValor;

	/**
	 * Montagem da tela composto.
	 *
	 * @param parent janela parente
	 * @param style estilo da janela que ser� aberta
	 */
	public ConsultarPrecoSWTComposite(Composite parent, int style) {
		super(parent, style);
		
		Label lblConsultaPreco = new Label(this, SWT.NONE);
		lblConsultaPreco.setBounds(23, 51, 72, 13);
		lblConsultaPreco.setText("Consulta Pre\u00E7o");
		
		txtCodProduto = new Text(this, SWT.BORDER);
		txtCodProduto.setBounds(101, 48, 76, 19);
		
		Button btnPesquisar = new Button(this, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtValor.setText("R$ 15,00");
			}
		});
		btnPesquisar.setBounds(209, 46, 68, 23);
		btnPesquisar.setText("Pesquisar");
		
		Label lblValor = new Label(this, SWT.NONE);
		lblValor.setBounds(23, 100, 49, 22);
		lblValor.setText("Valor:");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setEditable(false);
		txtValor.setBounds(101, 104, 76, 19);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Group#checkSubclass()
	 */
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
