package es.deusto.prog3.cap00.resueltos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TresEnRaya extends JFrame implements ActionListener {
    private JButton[][] tablero;
    private char jugadorActual;

    public TresEnRaya() {
        setTitle("Tres en Raya");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el tablero y el jugador actual
        tablero = new JButton[3][3];
        jugadorActual = 'X';

        // Crear un GridLayout 3x3 para el tablero
        setLayout(new GridLayout(3, 3));

        // Inicializar los botones del tablero
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna] = new JButton("");
                tablero[fila][columna].setFont(new Font("Arial", Font.PLAIN, 40));
                tablero[fila][columna].setFocusPainted(false);
                tablero[fila][columna].addActionListener(this);
                add(tablero[fila][columna]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        if (botonPresionado.getText().equals("")) {
            botonPresionado.setText(String.valueOf(jugadorActual));
            botonPresionado.setEnabled(false);

            // Verificar si hay un ganador
            if (hayGanador()) {
                JOptionPane.showMessageDialog(this, "¡Jugador " + jugadorActual + " ha ganado!");
                reiniciarJuego();
            } else if (tableroLleno()) {
                JOptionPane.showMessageDialog(this, "Empate");
                reiniciarJuego();
            } else {
                cambiarJugador();
            }
        }
    }

    private boolean hayGanador() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
        	//filas
            if (tablero[i][0].getText().equals(String.valueOf(jugadorActual)) &&
                tablero[i][1].getText().equals(String.valueOf(jugadorActual)) &&
                tablero[i][2].getText().equals(String.valueOf(jugadorActual))) {
                return true;
            }
            //columnas
            if (tablero[0][i].getText().equals(String.valueOf(jugadorActual)) &&
                tablero[1][i].getText().equals(String.valueOf(jugadorActual)) &&
                tablero[2][i].getText().equals(String.valueOf(jugadorActual))) {
                return true;
            }
        }
        //Diagonal principal
        if (tablero[0][0].getText().equals(String.valueOf(jugadorActual)) &&
            tablero[1][1].getText().equals(String.valueOf(jugadorActual)) &&
            tablero[2][2].getText().equals(String.valueOf(jugadorActual))) {
            return true;
        }
        //Diagonal secundaria 
        if (tablero[0][2].getText().equals(String.valueOf(jugadorActual)) &&
            tablero[1][1].getText().equals(String.valueOf(jugadorActual)) &&
            tablero[2][0].getText().equals(String.valueOf(jugadorActual))) {
            return true;
        }

        return false;
    }

    private boolean tableroLleno() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (tablero[fila][columna].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    private void reiniciarJuego() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna].setText("");
                tablero[fila][columna].setEnabled(true);
            }
        }
        jugadorActual = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TresEnRaya juego = new TresEnRaya();
            juego.setVisible(true);
        });
    }
}

