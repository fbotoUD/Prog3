package es.deusto.prog3.cap00.resueltos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TresEnRayaWb extends JFrame {
	
	private JButton[][] tablero;
    private char jugadorActual;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRayaWb frame = new TresEnRayaWb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TresEnRayaWb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jugadorActual = 'X';
		
		JButton btnNewButton_0_0 = new JButton("");
		btnNewButton_0_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JButton) e.getSource()).setText(String.valueOf(jugadorActual));
				jugadorActual = 'O';
			}
		});
		btnNewButton_0_0.setBounds(10, 11, 200, 200);
		btnNewButton_0_0.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_0_0.setFocusPainted(false);
		contentPane.add(btnNewButton_0_0);
		
		JButton btnNewButton_0_1 = new JButton("");
		btnNewButton_0_1.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_0_1.setFocusPainted(false);
		btnNewButton_0_1.setBounds(220, 11, 200, 200);
		contentPane.add(btnNewButton_0_1);
		
		JButton btnNewButton_0_2 = new JButton("");
		btnNewButton_0_2.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_0_2.setFocusPainted(false);
		btnNewButton_0_2.setBounds(430, 11, 200, 200);
		contentPane.add(btnNewButton_0_2);
		
		JButton btnNewButton_1_0 = new JButton("");
		btnNewButton_1_0.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_1_0.setFocusPainted(false);
		btnNewButton_1_0.setBounds(10, 222, 200, 200);
		contentPane.add(btnNewButton_1_0);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBounds(220, 222, 200, 200);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_1_2.setFocusPainted(false);
		btnNewButton_1_2.setBounds(430, 222, 200, 200);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_0 = new JButton("");
		btnNewButton_2_0.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_2_0.setFocusPainted(false);
		btnNewButton_2_0.setBounds(10, 433, 200, 200);
		contentPane.add(btnNewButton_2_0);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setBounds(220, 433, 200, 200);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.setFont(new Font("Arial", Font.PLAIN, 40));
		btnNewButton_2_2.setFocusPainted(false);
		btnNewButton_2_2.setBounds(430, 433, 200, 200);
		contentPane.add(btnNewButton_2_2);

	}
}