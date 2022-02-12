package no.ntnu.Connectionjdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


public class JdbcConnection {
    //fields
    private Connection connection;

    /**
     * We prevent creation of instances directly by making the constructor private
     * the intention is to use getIntance(), this way we enforce the singleton pattern
     */
    private JdbcConnection()
    {

    }

    /**
     * Singleton instance of the class
     */
    private static JdbcConnection instance;

    /**
     * Get a singleton instance of the class
     * @return
     */
    public static JdbcConnection getInstance()
    {
        if(instance == null)
        {
            instance = new JdbcConnection();
        }
        return instance;
    }

    /**
     * Connects to the db
     * @throws Exception
     */
    public void connect()throws Exception
    {
        this.connection = DriverManager.getConnection("jdbc:sqlite:libraryDB-dummydata.db");
    }

    /**
     * Checks if the connection to the database is established
     * @return
     */
    public boolean isConnected()
    {
        return connection != null;
    }

    /**
     * Updates the name and password for a given borrower by id
     * @param borrowerName new name to be changed
     * @param borrowerID id of the borrower to be changed
     * @param borrowerAddress new address to be changed
     * returns a string with the status the update
     * @return a string with the status the update
     */
    public String updateBorrowerNameAndAddress(String borrowerName, int borrowerID, String borrowerAddress)
    {
        PreparedStatement preparedStatement=null;
        String updateStatus="";
        try{
            preparedStatement.executeUpdate("UPDATE borrower SET firstName=(?), address=(?) WHERE borrowerID=(?)");
            preparedStatement.setString(1, borrowerName);
            preparedStatement.setString(2, borrowerAddress);
            preparedStatement.setInt(3, borrowerID);
            updateStatus="update successfull";
        } catch (Exception e) {
            System.out.println("error while updating borrower name and pw: " + e.getMessage());
            updateStatus="update failed";
        }

        return updateStatus;
    }

    /**
     * Returns the query
     * @param query query to be
     * @return
     */
    public void doQuery(String query)
    {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(query);
        } catch (Exception e) {
            System.out.println("error while getting all borrowers: " + e.getMessage());
        }
    }

    public List<String> getBooks(String query) throws Exception
    {
        return executeStringListQuery(query);
    }

    private List<String> executeStringListQuery(String query) throws Exception {
        PreparedStatement prep = this.connection.prepareStatement(query);
        ResultSet whatever = prep.executeQuery();
        List<String> list = new ArrayList<>();
        while(whatever.next())
        {
            list.add(whatever.getString(1));
        }
        return list;
    }

    public void addBook(int id, String title, String publisher, String releaseDate, int isbn, int branchID)
    {
        try{
            PreparedStatement prep = this.connection.prepareStatement("INSERT INTO books (bookID, title, publisher, releaseDate, isbn, branchID) VALUES (?,?,?,?,?,?)");
            prep.setInt(1, id);
            prep.setString(2, title);
            prep.setString(3, publisher);
            prep.setString(4, releaseDate);
            prep.setInt(5, isbn);
            prep.setInt(6, branchID);
        } catch (Exception e){
            System.out.println("Error while adding book: "+e.getMessage());
        }

    }


}
