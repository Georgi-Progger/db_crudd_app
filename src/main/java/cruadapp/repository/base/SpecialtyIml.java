package cruadapp.repository.base;

import cruadapp.model.Skill;
import cruadapp.model.Specialty;
import cruadapp.model.Status;
import cruadapp.repository.SpecialtyRepository;
import cruadapp.repository.base.util.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyIml implements SpecialtyRepository {
    public static SpecialtyIml specialtyIml;
    private SpecialtyIml(){}

    public static synchronized SpecialtyIml getSpecialtyIml(){
        if (specialtyIml == null){
            specialtyIml = new SpecialtyIml();
        }
        return specialtyIml;
    }

    @Override
    public Specialty getById(Integer integer) {
        String SQL = "SELECT * FROM specialty WHERE id = ?";
        Specialty specialty = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1,integer);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                specialty = new Specialty(resultSet.getInt("id"),resultSet.getString("name"));
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialties = new ArrayList<>();
        String SQL = "SELECT * FROM specialty";
        Specialty specialty = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                specialty = new Specialty(resultSet.getInt("id"), resultSet.getString("name"));
                if (resultSet.getBoolean("active")) {
                    specialty.setStatus(Status.ACTIVE);
                } else {
                    specialty.setStatus(Status.DELETED);
                }
                specialties.add(specialty);
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return specialties;
        }
    }

    @Override
    public Specialty save(Specialty specialty) {
        String SQL = "insert into specialty (name,active,developer_id) values (?,true,?)";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, specialty.getName());
            statement.setInt(2,specialty.getDeveloperId());
            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return specialty;
        }
    }

    @Override
    public Specialty update(Specialty specialty) {
        String SQL = "UPDATE specialty SET NAME = ? WHERE id = ?";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1,specialty.getName());
            statement.setInt(2,specialty.getId());


            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return specialty;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        String SQL = "UPDATE specialty SET ACTIVE = false WHERE id = ?";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1,integer);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
