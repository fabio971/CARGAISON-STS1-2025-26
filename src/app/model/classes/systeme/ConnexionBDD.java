package app.model.classes.systeme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {
	private static final String URL = "jdbc:mysql://localhost:3306/nom_de_ta_bdd";
    private static final String USER = "root";
    private static final String PASSWORD = "fenestros";

    public static Connection getConnection() {
        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données.");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
            System.out.println("Message : " + e.getMessage());
        }

        return connexion;
    }
}
