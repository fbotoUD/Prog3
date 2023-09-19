package es.deusto.prog3.cap00.resueltos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioUsuario extends JFrame{
	
	
	JTextField nombretf, apellidostf, emailtf;
	JPasswordField passtf;
	JButton guardar;
	
	public FormularioUsuario() {
		
		setTitle("Formulario de usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 250);
		setLayout(new GridLayout(6, 2));
		
		JLabel nombre = new JLabel("Nombre");
		nombretf = new JTextField();
		JLabel apellidos = new JLabel("Apellidos");
		apellidostf = new JTextField();
		JLabel email = new JLabel("E-Mail");
		emailtf = new JTextField();
		JLabel password = new JLabel("Password");
		passtf = new JPasswordField();
		
		guardar = new JButton("Guardar");
		
		add(nombre);
		add(nombretf);
		add(apellidos);
		add(apellidostf);
		add(email);
		add(emailtf);
		add(password);
		add(passtf);
		add(guardar);
		
		setVisible(true);
		
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreTemp = nombretf.getText();
				String apellidosTemp = apellidostf.getText();
				String emailTemp = emailtf.getText();
				char[] passTemp = passtf.getPassword();
				
				System.out.println("Nombre: " + nombreTemp);
				System.out.println("Apellidos: " + apellidosTemp);
				System.out.println("E-Mail: " + emailTemp);
				System.out.println("Contraseña: " + new String(passTemp));				
				
			}
		});
	}
	
	
	public static void main(String[] args) {
//		JFrame formulario = new FormularioUsuario();
		SwingUtilities.invokeLater(() -> {
	            new FormularioUsuario();
	        });
	}
}
