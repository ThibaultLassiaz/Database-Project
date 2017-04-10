

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
//import java.util.Scanner;

public class Connexionsgbd {

    private static final String configurationFile
            = "BD.properties";

    
    ////////////////////////////////////////////////////////////
    // PAS IMPLEMENTE EN GRAPHIQUE //
    ////////////////////////////////////////////////////////////
    
    // CONNEXION DU CLIENT OU DE L'AGENCE
    public int Connect(int idClient, String mdpClient) {
        int ClientID = 0;
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings
            Statement stmt = conn.createStatement();
                // Execute the query
                ResultSet rs = stmt.executeQuery("SELECT idClient FROM CONNEXION Where idClient = " + idClient +" and mdpClient = '" + mdpClient + "'");
                while (rs.next()) {
                     ClientID = rs.getInt(1);
                }
                // Close the result set, statement and the connection 
                rs.close();
                stmt.close();

            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return 0;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    return ClientID;
    }
    
    
    
    ////////////////////////////////////////////////////////////
    // PAS IMPLEMENTE EN GRAPHIQUE //
    ////////////////////////////////////////////////////////////
    
    // CREER UNE PROGRAMMATION POUR UN VOYAGE DONNE A UNE DATE DONNEE //
    // ACCESSIBLE POUR L'AGENCE UNIQUEMENT //
    public void CreateProgrammation(int idVoyage, Date dateDep, int idResponsable) {
        try {
            int idProg = 0;
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings
            Statement stmt = conn.createStatement();
                // Execute the query
                ResultSet rs = stmt.executeQuery("SELECT max(idProg) FROM PROGRAMMATION");
                while (rs.next()) {
                    idProg = rs.getInt(1)+1;
                }
                rs.close();
                stmt.close();
                
            Statement stmtinsert = conn.createStatement();
                // Execute the query
            
                ResultSet rsinsert = stmtinsert.executeQuery("INSERT INTO Programmation (idProg, idVoyage, dateDep, idResp) values ("+ idProg +
                                                             ","+ idVoyage +
                                                             ",'"+ dateDep +
                                                             "',"+ idResponsable +")");
                
                System.out.println(rsinsert);
                rsinsert.close();
                stmtinsert.close();

            conn.close();

            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    
    ////////////////////////////////////////////////////////////
    // PAS IMPLEMENTE EN GRAPHIQUE //
    ////////////////////////////////////////////////////////////
    
    // ANNULE UNE INSCRIPTION POUR UN VOYAGE SELECTIONNE PAR LE CLIENT AUQUEL IL EST INSCRIT //
    // ACCESSIBLE POUR LES CLIENTS UNIQUEMENT //
    public void InsertParticipation(int idProg, int idClient, String referent) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings
                
            Statement stmtinsert = conn.createStatement();
                // Execute the query
            
                ResultSet rsinsert = stmtinsert.executeQuery("INSERT INTO PARTICIPATION (idProg, idClient, referent) values ("+ idProg +
                                                             ","+ idClient +
                                                             "',"+ referent +"')");
                
                System.out.println(rsinsert);
                rsinsert.close();
                stmtinsert.close();
            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    
    ////////////////////////////////////////////////////////////
    // PAS IMPLEMENTE EN GRAPHIQUE //
    ////////////////////////////////////////////////////////////
    
    // ANNULE UNE INSCRIPTION POUR UN VOYAGE SELECTIONNE PAR LE CLIENT AUQUEL IL EST INSCRIT //
    // ACCESSIBLE POUR LES CLIENTS UNIQUEMENT //
    public void DeleteParticipation(int idProg, int idClient) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings
            Statement stmt = conn.createStatement();
                // Execute the query
                ResultSet rs = stmt.executeQuery("DELETE FROM PARTICIPATION WHERE idProg = " + idProg + " and idClient = " + idClient + "");
                rs.close();
                stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////
    // TOUTES LES METHODES A PARTIR D'ICI SONT IMPLEMENTEES EN GRAPHIQUE //
    ///////////////////////////////////////////////////////////////////////
    
    
    // REMPLI LES TABLEVIEW EN GRAPHIQUE //
    //PERMET DE VISUALISER TOUS LES VOYAGES //
    public void FillTableView(TableView tab) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings   
            Statement stmt = conn.createStatement();
                // Execute the query
                ObservableList<VoyageClass> data = FXCollections.observableArrayList();
                
                ResultSet rs = stmt.executeQuery("SELECT * FROM VOYAGE");
                while (rs.next()) {
                    VoyageClass v1 = new VoyageClass(rs.getString(1), rs.getString(10), rs.getString(8), rs.getString(9), rs.getString(11), rs.getString(12), rs.getString(7));
                    data.add(v1);
                    tab.setItems(data);
                }
                // Close the result set, statement and the connection 
                rs.close();
                stmt.close();

            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    
    
    // REMPLI LES COMBOBOX DES VILLES AFIN DE CREER DES VOYAGES ET DES ETAPES //
    public void FillCity(ArrayList<Pair> ListeVille) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings   
            Statement stmt = conn.createStatement();
                // Execute the query               
                ResultSet rs = stmt.executeQuery("SELECT idVille, nomVille FROM VILLE");
                while (rs.next()) {
                    Pair p1 = new Pair(rs.getInt(1), rs.getString(2));
                    ListeVille.add(p1);
                }
                // Close the result set, statement and the connection 
                rs.close();
                stmt.close();

            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    
    // RECUPERE LA VALEUR DU DERNIER IDVOYAGE //
    public int GetMaxIdVoyage() {
        int max = 0;
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings   
            Statement stmt = conn.createStatement();
                // Execute the query
                ObservableList<VoyageClass> data = FXCollections.observableArrayList();
                
                ResultSet rs = stmt.executeQuery("SELECT MAX(idvoyage) FROM VOYAGE");
                while (rs.next()) {
                    max = rs.getInt(1);
                }
                // Close the result set, statement and the connection 
                rs.close();
                stmt.close();

            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return 0;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
        return max;
    }
    
    
    // INSERT UNE ETAPE POUR UN VOYAGE DONNE //
    public void InsertEtape(int idville, int idvoyage, String numero, String duree) {
        try {
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings   
            Statement stmt = conn.createStatement();
                // Execute the query
                       
                ResultSet rs = stmt.executeQuery("INSERT INTO ETAPE (idVille, idVoyage, numero, duree) values (" + idville +
                                                                                                             "," + idvoyage +
                                                                                                             "," + numero +
                                                                                                             "," + duree + ")");
                // Close the result set, statement and the connection 
                rs.close();
                stmt.close();

            conn.close();
            System.out.println("Etape ajoutée !");
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    // INSERT UN VOYAGE CREE DANS L'INTERFACE ADMIN //
    public void InsertVoyage(int idformule, int idtypevoyage, int idvilledep, int idvillea, String nbpersmin, String nbpersmax, String duree, String prixvoyage, String description, String typeVoyage, String difficulte) {
        try {
            int id = 0;
            String jdbcDriver, dbUrl, username, password;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();
            // Load the database driver
            Class.forName(jdbcDriver);
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            // Print information about connection warnings   
            Statement stmt = conn.createStatement();
                // Execute the query
              
                ResultSet rs = stmt.executeQuery("SELECT max(idvoyage) FROM Voyage");
                while (rs.next()) {
                    id = rs.getInt(1)+1;
                }
                rs.close();
                stmt.close();
                
            Statement stmtinsert = conn.createStatement();
                // Execute the query
            
                ResultSet rsinsert = stmtinsert.executeQuery("INSERT INTO Voyage (idVoyage, idFormule, idTypeVoyage, idVilleA, idVilleD, nbPersMin, nbPersMax, duree, prixVoyage, description, typeVoyage, difficulte) values ("+ id +
                                                             ","+ idformule +
                                                             ","+ idtypevoyage +
                                                             ","+ idvillea +
                                                             ","+ idvilledep +
                                                             ","+ nbpersmin +
                                                             ","+ nbpersmax +
                                                             ","+ duree +
                                                             ","+ prixvoyage +
                                                             ",'"+ description +
                                                             "','"+ typeVoyage +
                                                             "',"+ difficulte +")");
                
                System.out.println(rsinsert);
                rsinsert.close();
                stmtinsert.close();

            conn.close();
        } catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
            return;
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
    
    
}
