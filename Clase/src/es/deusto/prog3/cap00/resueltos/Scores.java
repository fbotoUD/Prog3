package es.deusto.prog3.cap00.resueltos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scores {
    private Map<String, List<Integer>> userScores;

    public Scores() {
        userScores = new HashMap<>();
    }

    // Agregar una puntuación para un usuario dado
    public void addScore(String username, int score) {
        // Verificar si el usuario ya existe en el hashmap
        if (userScores.containsKey(username)) {
            userScores.get(username).add(score); // Agrega la puntuación a la lista existente
        } else {
            List<Integer> scores = new ArrayList<>();
            scores.add(score); // Crear una nueva lista y agregar la puntuación
            userScores.put(username, scores);
        }
    }

    // Obtener todas las puntuaciones de un usuario
    public List<Integer> getScores(String username) {
        return userScores.get(username);
    }

    // Obtener la puntuación promedio de un usuario
    public double getAverageScore(String username) {
        List<Integer> scores = userScores.get(username);
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    // Eliminar todas las puntuaciones de un usuario
    public void clearScores(String username) {
        userScores.remove(username);
    }

    // Mostrar todas las puntuaciones de todos los usuarios
    public void displayAllScores() {
        for (Map.Entry<String, List<Integer>> entry : userScores.entrySet()) {
            String username = entry.getKey();
            List<Integer> scores = entry.getValue();
            System.out.print(username + ": ");
            for (int score : scores) {
                System.out.print(score + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scores scoreManager = new Scores();

        scoreManager.addScore("user1", 100);
        scoreManager.addScore("user1", 150);
        scoreManager.addScore("user2", 200);
        scoreManager.addScore("user2", 250);
        scoreManager.addScore("user3", 300);

        scoreManager.displayAllScores();

        System.out.println("Average score for user1: " + scoreManager.getAverageScore("user1"));
        System.out.println("Average score for user2: " + scoreManager.getAverageScore("user2"));
        System.out.println("Average score for user3: " + scoreManager.getAverageScore("user3"));
    }
}

