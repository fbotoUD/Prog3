package es.deusto.prog3.cap00.resueltos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class VentanaSeleccionDatos extends JFrame {
    private JList<String> listaUsuarios;
    private DefaultListModel<String> listModel;
    private JButton verButton;
    private JButton editarButton;
    private List<String> usuarios;

    public VentanaSeleccionDatos() {
        setTitle("Selección de Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

//        listModel = new DefaultListModel<>();
//        for (int i = 0; i < 100; i++) {
////        	listModel.addElement("Usuario " + Integer.toString(i));
//
//        }
        String nombreArchivo = "src/es/deusto/prog3/cap00/resueltos/DatosUsuarios.txt";
        listModel = leerNombresDesdeArchivo(nombreArchivo);

        listaUsuarios = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaUsuarios);

        verButton = new JButton("Ver");
        editarButton = new JButton("Editar");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(verButton);
        buttonPanel.add(editarButton);

        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaUsuarios.getSelectedIndex();
                if (selectedIndex != -1) {
                    String usuarioSeleccionado = listModel.getElementAt(selectedIndex);
                    JOptionPane.showMessageDialog(VentanaSeleccionDatos.this, "Usuario seleccionado: " + usuarioSeleccionado, "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaUsuarios.getSelectedIndex();
                if (selectedIndex != -1) {
//                    
                    abrirVentanaEdicion(selectedIndex);
//                    
                }
            }
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private DefaultListModel<String> leerNombresDesdeArchivo(String nombreArchivo) {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                listModel.addElement(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return listModel;
    }

    private void abrirVentanaEdicion(int idx) {
    	
    	String valorPredeterminado = listModel.getElementAt(idx);
    	String entrada = JOptionPane.showInputDialog("Introduce el nombre modificado:",valorPredeterminado);

        // Verificar si el usuario ha introducido algo
        if (entrada != null && !entrada.isEmpty()) {
//           
        	listModel.setElementAt(entrada, idx);
        } else {
            JOptionPane.showMessageDialog(null, "No hay modificación");
        }    	
    	
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            VentanaSeleccionDatos ventana = new VentanaSeleccionDatos();
//            ventana.setVisible(true);
//        });
    	
    	VentanaSeleccionDatos ventana = new VentanaSeleccionDatos();
    	ventana.setVisible(true);
    }
    
    
}
