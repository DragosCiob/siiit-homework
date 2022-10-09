package siit.homework10;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class BookingDataBaseTestReworked {


    private static Connection connection;

    @BeforeAll
    public static void setConnection()  {

        try {
            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL("jdbc:h2:mem:test.db");
            connection = ds.getConnection();

            connection.createStatement().executeUpdate("CREATE TABLE accommodation (id integer NOT NULL UNIQUE PRIMARY KEY, type character varying(32) NOT NULL,bed_type character varying(32) NOT NULL, max_guests integer , description character varying(512))");
            connection.createStatement().executeUpdate("CREATE TABLE room_fair (id integer NOT NULL UNIQUE PRIMARY KEY, room_price double precision NOT NULL,season character varying(32) NOT NULL)");
            connection.createStatement().executeUpdate("CREATE TABLE accommodation_fair_relation (id integer NOT NULL UNIQUE PRIMARY KEY,accommodation_id integer NOT NULL, room_fair_id integer NOT NULL, FOREIGN KEY (accommodation_id) REFERENCES accommodation (id),FOREIGN KEY (room_fair_id) REFERENCES room_fair (id))");


            addElementsToAccomodation();

            addElementsToRoomFair();

            addElementsToAccomodationFairRelation();

        }catch (SQLException e){
            throw new RuntimeException("something went wrong");
        }

    }

    public static  void addElementsToAccomodation() throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO accommodation " + " VALUES ( 1, 'Single room', 'Single bed', 1, 'Near central railway')");
        statement.executeUpdate("INSERT INTO accommodation " + " VALUES ( 2, 'Double room', 'King size', 2, 'Near Goodison Park Stadium')");
        statement.executeUpdate("INSERT INTO accommodation " + " VALUES ( 3, 'Double room', 'King size', 2, 'Near Royal Court Theatre')");

    }
    public static  void addElementsToRoomFair() throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO room_fair "+"  VALUES ( 1, 800.0, 'Summer')");
        statement.executeUpdate("INSERT INTO room_fair "+"  VALUES ( 2, 1400.0, 'Summer')");
        statement.executeUpdate("INSERT INTO room_fair "+"  VALUES ( 3, 1550.0, 'Summer')");

    }

    public static  void addElementsToAccomodationFairRelation() throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO accommodation_fair_relation " + " VALUES ( 1,1,1)");
        statement.executeUpdate("INSERT INTO accommodation_fair_relation " + " VALUES ( 2,2,2)");
        statement.executeUpdate("INSERT INTO accommodation_fair_relation " + " VALUES ( 3,3,3 )");

    }

    /**
     * method to generate Room objects used in test
     *
     */
    public static List<Room> generateRoom() throws SQLException {

       List<Room> roomsList= new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT accommodation.type, room_fair.room_price FROM accommodation_fair_relation " +
                "JOIN accommodation ON (accommodation_fair_relation.accommodation_id=accommodation.id) " +
                "JOIN room_fair ON (accommodation_fair_relation.room_fair_id=room_fair.id)");

        while (resultSet.next()){

           roomsList.add( new Room(resultSet.getInt(2), resultSet.getString(1)));

        }
        return  roomsList;

    }



    @Test
    public void query_Values_Test() {
        List<Room> listToCheck ;

        try {
          listToCheck = generateRoom();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1400 , listToCheck.get(1).getRoomPrice());
        Assertions.assertEquals(800 , listToCheck.get(0).getRoomPrice());

        Assertions.assertEquals("Double room" , listToCheck.get(1).getRoomType());
        Assertions.assertEquals("Single room" , listToCheck.get(0).getRoomType());

    }

    @Test
    public void print_Query_Results_Test() {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT accommodation.type, accommodation.bed_type, room_fair.room_price FROM accommodation_fair_relation " +
                    "JOIN accommodation ON (accommodation_fair_relation.accommodation_id=accommodation.id) " +
                    "JOIN room_fair ON (accommodation_fair_relation.room_fair_id=room_fair.id)");

            while (resultSet.next()){
                System.out.println("Room type: " + resultSet.getString("type")  + "  Room price: " + resultSet.getDouble("room_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
