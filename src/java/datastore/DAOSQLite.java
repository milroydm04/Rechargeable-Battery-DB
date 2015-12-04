package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Batt;

/**
 * DAOSQLite Data Access Object for an SQLite database
 *
 * @author Dylan Lozo
 * @version 0.3 on 2015-11-03 revised 2015-11-24
 */
public class DAOSQLite {

    protected final static String DRIVER = "org.sqlite.JDBC";
    protected final static String JDBC = "jdbc:sqlite";

    /**
     * Inserts an record into the database table. Note the use of a
     * parameterized query to prevent SQL Injection attacks.
     *
     * @param book the object to insert
     * @param dbPath the path to the SQLite database
     */
    public static void createRecord(Batt book, String dbPath) {
        String q = "insert into book (bookName, bookAuthor, bookSection, iSBN, copyrightYear) "
                + "values (?, ?, ?, ?, ?)";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setString(1, book.getManufacturer());
            ps.setString(2, book.getDateBought());
            ps.setString(3, book.getNumberMarriedto());
            ps.setString(4, book.getAmpLimits());
            ps.setInt(5, book.getBatteryType());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retrieve all of the records in the database as a list sorted by
     * name. This method was replaced by a more advanced method.
     *
     * @param dbPath the path to the SQLite database
     * @return list of objects
     */
    public static List<Batt> retrieveAllRecords(String dbPath) {
        String q = "select * from book order by bookName";
        List<Batt> list = null;
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            list = myQuery(conn, ps);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
//    /**
//     * This is a much more advanced retrieve method. It can get all of the
//     * records from the database or a subset based on the various parameters
//     * passed in.
//     *
//     * @param dbPath the path to the SQLite database
//     * @param gameName - the name of the video game
//     * @return list of objects
//     */
//    public static List<Game> retrieveRecords(String dbPath, String gameName) {
//        String q = "select * from game order by gameName";
//
//        List<Game> list = null;
//        try (Connection conn = getConnectionDAO(dbPath);
//                PreparedStatement ps = conn.prepareStatement(q)) {
//            // the % sign is an sql wildcard so that we can search by just a few letters of the game name
//            ps.setString(1, gameName + "%");
//            System.out.println(q);
//            list = myQuery(conn, ps);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOSQLite.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

    /**
     * Delete a record from the database given its name. Note the use of a
     * parameterized query to prevent SQL Injection attacks.
     *
     * @param bookName the name of the record to delete
     * @param dbPath the path to the SQLite database
     */
    public static void deleteRecord(String bookName, String dbPath) {
        String q = "delete from book where bookName = ?";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setString(1, bookName);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new user table.
     *
     * @param dbPath the path to the SQLite database
     */
    public static void createTable(String dbPath) {
        String q = "create table book ("
                + "bookName varchar(50), "
                + "bookAuthor varchar(20) not null, "
                + "bookSection varchar(200) not null, "
                + "iSBN varchar(20) not null, "
                + "copyrightYear int not null);";
        System.out.println("createtable " + q);
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Drops the user table erasing all of the data.
     *
     * @param dbPath the path to the SQLite database
     */
    public static void dropTable(String dbPath) {
        final String q = "drop table if exists book";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Populates the table with sample data records.
     *
     * @param dbPath the path to the SQLite database
     */
    public static void populateTable(String dbPath) {
        Batt p;
        p = new Batt("SONY VTC4", "11/15/2015", "A", "30/60", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("SONY VTC4", "11/15/2015", "A", "30/60", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("LG", "8/15/2015", "B", "20/35", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("LG", "8/15/2015", "B", "20/35", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("SONY VTC4", "12/29/2015", "C", "30/60", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("SONY VTC4", "12/29/2015", "C", "30/60", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("SONY VTC4", "12/29/2015", "C", "30/60", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("SONY VTC4", "12/29/2015", "C", "30/60", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("LG", "1/29/2015", "AA", "20/35", 18650);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("Eleaf", "3/29/2015", "BB", "10/15", 18350);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("Samsung", "5/29/2015", "D", "15/25", 18350);
        DAOSQLite.createRecord(p, dbPath);
        p = new Batt("Samsung", "5/29/2015", "D", "15/25", 18350);
        DAOSQLite.createRecord(p, dbPath);
    }

    /**
     * A helper method that executes a prepared statement and returns the result
     * set as a list of objects.
     *
     * @param conn a connection to the database
     * @param ps a prepared statement
     * @return list of objects from the result set
     */
    protected static List<Batt> myQuery(Connection conn, PreparedStatement ps) {
        List<Batt> list = new ArrayList();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String bookName = rs.getString("bookName");
                String bookAuthor = rs.getString("bookAuthor");
                String bookSection = rs.getString("bookSection");
                String iSBN = rs.getString("iSBN");
                int copyrightYear = rs.getInt("copyrightYear");
                Batt p = new Batt(bookName, bookAuthor, bookSection, iSBN, copyrightYear);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * Creates a connection to the SQLite database.
     *
     * @param dbPath the path to the SQLite database
     * @return connection to the database
     */
    protected static Connection getConnectionDAO(String dbPath) {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(JDBC + ":" + dbPath);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
