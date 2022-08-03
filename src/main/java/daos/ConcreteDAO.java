package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

import static daos.ConcreteFactory.getConnection;

public class ConcreteDAO implements DAO {

    ConcreteDTO getConcrete;

    List<ConcreteDTO> concreteDTOList;


    public Object findById(int id) {
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public List findAll() {
        return concreteDTOList;
    }

    public Object update(Object dto) {
        for (Object object : concreteDTOList)

        return object;
    }

    public Object create(Object dto) {
        return dto;
    }

    public void delete(int id) {

    }

    public Concrete getConcrete(int id) {
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if (rs.next()) {
                Concrete user = new Concrete();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setAge(rs.getInt("age"));

                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private Concrete extractUserFromResultSet(ResultSet rs) throws SQLException {
        Concrete user = new Concrete();

        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPass(rs.getString("pass"));
        user.setAge(rs.getInt("age"));

        return user;
    }
}
