package application; 
package comm.dao; // Supposons que cette classe est dans un package comm.dao

import comm.bdd.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonDAO {
    
    public void getDataFromDB() {
        // Obtention de la connexion à la base de données depuis DatabaseManager
        Connection connection = DatabaseManager.getConnection();

        try {
            // Exemple de requête SQL pour récupérer des données
            String query = "SELECT * FROM MaTable";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Traitement des résultats
            while (resultSet.next()) {
                // Lire les données du résultat de la requête
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");

                // Faire quelque chose avec les données récupérées
                // Par exemple, les afficher ou les traiter d'une autre manière
                System.out.println("ID : " + id + ", Nom : " + nom);
            }

            // Fermeture des ressources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Il est recommandé de libérer la connexion à la base de données après usage
            DatabaseManager.closeConnection();
        }
    }
}
