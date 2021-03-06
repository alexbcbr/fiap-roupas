package com.fiaproupas.svl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.fiaproupas.svl.composite.ConsultarEstoqueSWTComposite;
import com.fiaproupas.svl.composite.ConsultarPrecoSWTComposite;

/**
 * The Aplica��o que chama todas as janelas da funcionalidade de consulta
 * @author alexbc
 * @version 1.0
 */
public class RealizarConsultaSWT {

	/** Abstra��o que representa a janela de top-level da aplica��o */
	protected Shell shell;
	
	/** pagina de composi��o do fluxo de nevegacao das telas */
	static Composite pageComposite;
	
	/**
	 * Launch da aplica��o
	 */
	public static void main(String[] args) {
		try {
			RealizarConsultaSWT window = new RealizarConsultaSWT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abrir janela gr�fica.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Montado o desenho da tela e anexado todos os composites que far�o parte da navega��o da aplica��o.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(714, 518);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout());  //* necessario definir um layout para fazer composicao. Este linha deve ser incluida no codigo gerado
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmConsultarPreco = new MenuItem(menu, SWT.NONE);
		mntmConsultarPreco.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ((pageComposite != null) && (!pageComposite.isDisposed()))	pageComposite.dispose();

				pageComposite = new ConsultarPrecoSWTComposite(shell, SWT.NONE);
				shell.layout(true);		
			}
		});
		mntmConsultarPreco.setText("Consultar Pre\u00E7o");
		
		MenuItem mntmConsultarEstoque = new MenuItem(menu, SWT.NONE);
		mntmConsultarEstoque.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if ((pageComposite != null) && (!pageComposite.isDisposed()))	pageComposite.dispose();
				
				pageComposite = new ConsultarEstoqueSWTComposite(shell, SWT.NONE);
				shell.layout(true);
			}
		});
		mntmConsultarEstoque.setText("Consultar Estoque");
		
		pageComposite = new Composite(shell, SWT.NONE);
		pageComposite.setLayout(new GridLayout());

	}
}
