package siit.homework10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class BookingDataBaseTest {


    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test_mem");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * tables created for In-Memory database
     */
    @BeforeAll
    static void initializeConnection() {
        try {
            connection.createStatement().executeUpdate("CREATE TABLE accommodation (id integer NOT NULL UNIQUE PRIMARY KEY, type character varying(32) NOT NULL,bed_type character varying(32) NOT NULL, max_guests integer , description character varying(512))" );
            connection.createStatement().executeUpdate("CREATE TABLE room_fair (id integer NOT NULL UNIQUE PRIMARY KEY, room_price double precision NOT NULL,season character varying(32) NOT NULL)");
            connection.createStatement().executeUpdate("CREATE TABLE accommodation_fair_relation (id integer NOT NULL UNIQUE PRIMARY KEY,accommodation_id integer NOT NULL, room_fair_id integer NOT NULL, FOREIGN KEY (accommodation_id) REFERENCES accommodation (id),FOREIGN KEY (room_fair_id) REFERENCES room_fair (id))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        accommodationInsert(connection, 1, "Single room", "Single bed", 1, "Near central railway");
        roomFairInsert(connection, 1, 800.0, "Summer");
        AccomodationFairRelationInsert(connection, 1, 1, 1);

        accommodationInsert(connection, 2, "Double room", "King size", 2, "Near Goodison Park Stadium");
        roomFairInsert(connection, 2, 1400.0, "Summer");
        AccomodationFairRelationInsert(connection, 2, 2, 2);

        accommodationInsert(connection, 3, "Double room", "King size", 2, "Near Royal Court Theatre");
        roomFairInsert(connection, 3, 1550.0, "Summer");
        AccomodationFairRelationInsert(connection, 3, 3, 3);

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


    @Test
    public void query_Values_Test() {
        List<String> accommodationTypes = new ArrayList<>();
        List<Double> roomValues = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT accommodation.type, accommodation.bed_type, room_fair.room_price FROM accommodation_fair_relation " +
                    "JOIN accommodation ON (accommodation_fair_relation.accommodation_id=accommodation.id) " +
                    "JOIN room_fair ON (accommodation_fair_relation.room_fair_id=room_fair.id)");

            while (resultSet.next()){
                accommodationTypes.add(resultSet.getString("type"));
                roomValues.add(resultSet.getDouble("room_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(800, roomValues.get(0));
        Assertions.assertEquals("Single room", accommodationTypes.get(0));

        Assertions.assertEquals(1550.0, roomValues.get(2));
        Assertions.assertEquals("Double room", accommodationTypes.get(2));
    }

    /**
        accommodation insert statement
     */
    public static void accommodationInsert (Connection connection, Integer id, String type, String bedType, Integer maxGuests, String description){
        try {
            PreparedStatement accommodationInsertStatement = connection.prepareStatement("INSERT INTO accommodation VALUES (? , ? , ? , ? , ?)");

            accommodationInsertStatement.setInt(1, id);
            accommodationInsertStatement.setString(2, type);
            accommodationInsertStatement.setString(3, bedType);
            accommodationInsertStatement.setInt(4, maxGuests);
            accommodationInsertStatement.setString(5, description);

            accommodationInsertStatement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     roomFair insert statement
     */
    public static void roomFairInsert (Connection connection, Integer id, Double price, String season){
        try {
            PreparedStatement roomFairPreparedStatement = connection.prepareStatement("INSERT INTO room_fair VALUES (? , ? , ?)");

            roomFairPreparedStatement.setInt(1, id);
            roomFairPreparedStatement.setDouble(2, price );
            roomFairPreparedStatement.setString(3, season);

            roomFairPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     AccomodationFairRelation insert statement
     */
    public static void AccomodationFairRelationInsert(Connection connection, Integer id, Integer accommodationId, Integer roomFairId){
        try {
            PreparedStatement roomFairPreparedStatement = connection.prepareStatement("INSERT INTO accommodation_fair_relation VALUES (? , ? , ?)");

            roomFairPreparedStatement.setInt(1, id);
            roomFairPreparedStatement.setInt(2, accommodationId);
            roomFairPreparedStatement.setInt(3, roomFairId);

            roomFairPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

