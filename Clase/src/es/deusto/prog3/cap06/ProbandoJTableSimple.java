package es.deusto.prog3.cap06;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hamcrest.core.IsInstanceOf;


public class ProbandoJTableSimple {
	
	private static JFrame vent;
	private static JTable tabla;
	
	private static DefaultTableModel modelo;

	public static void main(String[] args) {
		
		vent = new JFrame();
		vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vent.setSize(400,300);
//		vent.setLocation(2000, 0);
		
		//Hay componentes que se asocia un modelo de datos JTable es uno de ellos
		//Patrón de diseño en el que por una parte tengo la gestión de los datos y por otro la visualización
		modelo = new DefaultTableModel(new Object[] {"Name","Cod"},0);
				
		//Tabla en la ventana
		tabla = new JTable(modelo);
//		vent.getContentPane().add(tabla,BorderLayout.CENTER);
		
		
		//Es interesante poner scroll
		JScrollPane scroll = new JScrollPane(tabla);
		vent.getContentPane().add(scroll,BorderLayout.CENTER);
		
		//Se puede crear el JScrollPane directamente
//		vent.getContentPane().add(new JScrollPane(tabla), BorderLayout.CENTER);
//		
		//Añadir datos
		modelo.addRow(new Object[] {"Miren",70});
		modelo.addRow(new Object[] {"Mara",500});
		modelo.addRow(new Object[] {"Oihan",250});
		
		//Anchura columnas (es visual está en la tabla, no en el modelo)
//		tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
//		tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabla.getColumnModel().getColumn(0).setMaxWidth(300);
		tabla.getColumnModel().getColumn(0).setMinWidth(100);
//		tabla.getColumnModel().getColumn(0).setMinWidth(100);
//		tabla.getColumnModel().getColumn(1).setMaxWidth(200);
//		tabla.getColumnModel().getColumn(1).setMinWidth(80);
		
		//Investigamos el modelo
		modelo = new DefaultTableModel(new Object[] {"Name","Cod"},0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println("isCellEditable"+row+","+column);
				if (column == 0) return false;
				else return super.isCellEditable(row, column);
				
			}

			@Override
			public Object getValueAt(int row, int column) {
				Object val = super.getValueAt(row, column);
				System.out.println("getValueAt "+row+","+column+"<-"+ val);
				return val;
			}

			@Override
			public void setValueAt(Object aValue, int row, int column) {
				System.out.println("setValueAt "+row+","+column +"->" +aValue);
//				if (aValue.getClass().equals(String.class)) return;
				if(column==0) {
					super.setValueAt(aValue, row, column);
				}
				else {
					try {
						int valor = Integer.parseInt(aValue+"");
						if (valor <=255) {
							super.setValueAt(aValue, row, column);
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			} // Hereda de DefaultTableModel
			
		};
		modelo.addRow(new Object[] {"Osane",70});
		modelo.addRow(new Object[] {"Ane",125});
		modelo.addRow(new Object[] {"Oihan",250});
		tabla.setModel(modelo);
		
		//Evitar reordenación de columnas
//		tabla.getTableHeader().setReorderingAllowed(false);
//		
//		

		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				Component compo = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				System.out.println("Soy un JLabel?: "+(compo instanceof JLabel));
				JLabel label = (JLabel)compo;
				if (column == 0) {
					compo.setBackground(Color.GRAY);
				}
				else {
					compo.setBackground(Color.WHITE);
					int valor = (int) modelo.getValueAt(row, column);
					compo = new JSlider(0,255,valor);
				}
				return compo;
			}
			
		});
		
		tabla.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
			int valorAnt;
			Component compo;
			JTextField tf;
			

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				
				compo = super.getTableCellEditorComponent(table, value, isSelected, row, column);
				tf = (JTextField) compo;
				if(column == 1) {
					int valor = (int) value;
					tf = null;
					compo = new JSlider(0,255,valor);
					((JSlider)compo).addChangeListener(new ChangeListener() {
						
						@Override
						public void stateChanged(ChangeEvent e) {
							valorAnt = ((JSlider)compo).getValue();
							
						}
					});
					
				}
				
				
				return compo;
			}
			
			
			@Override
			public Object getCellEditorValue() {
				if (tf != null) {
					return tf.getText();
				}
				else {
					return valorAnt;
				}
				
			}
			
		});
		
		
		
		tabla.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
				
		
		vent.setVisible(true);
		
		
	}
	
	
	
	

}
