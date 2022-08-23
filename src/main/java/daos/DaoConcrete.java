package daos;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DaoConcrete implements DAO{
    private List<Object> dtoConcreteList = new ArrayList<>();
    private DAO repository;
    @Override
    public Object findById(int id) {
        Connection connection = connectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car WHERE Id=" + id);

            if(resultSet.next()) {
                Car car = new Car();

                car.setId(resultSet.getInt("Id"));
                car.setMake(resultSet.getString("Make"));
                car.setModel(resultSet.getString("Model"));
                car.setYear(resultSet.getInt("Year"));
                car.setColor(resultSet.getString("Color"));
                car.setVin(resultSet.getString("Vin"));

                return car;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List findAll() {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car");

            List cars = (List) new HashSet();

            while (resultSet.next()) {
                Car car = extractCarResultSet(resultSet);
                cars.add(car);
            }
            return cars;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Object update(Car car) throws SQLException {
        Connector connector = new Connector();
        Connection connection = connector.getConnector();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET Make=?, Model=?, Year=?, Color=?, Vin=?");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Object create(Car car) {
        Connector connector = new Connector();
        Connection connection = connector.getConnector();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (NULL, ?, ?, ?)");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connector connector = new Connector();
        Connection connection = connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM car WHERE Id=" + id);

            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
