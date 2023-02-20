package cruadapp.repository.base;

import cruadapp.model.Developer;
import cruadapp.model.Skill;
import cruadapp.model.Specialty;
import cruadapp.model.Status;
import cruadapp.repository.DeveloperRepository;
import cruadapp.repository.base.util.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperIml  implements DeveloperRepository {
    public static DeveloperIml developerIml;

    private DeveloperIml() {
    }

    public static synchronized DeveloperIml getDeveloperIml(){
        if (developerIml == null){
            developerIml = new DeveloperIml();
        }
        return developerIml;
    }

    @Override
    public Developer getById(Integer integer) {
        String SQL = "SELECT * FROM developers WHERE id = ?";
        Developer developer = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1,integer);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                developer = new Developer(resultSet.getInt("id"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"),getSkills(),getSpecialty());
                if (resultSet.getBoolean("active")) {
                    developer.setStatus(Status.ACTIVE);
                } else {
                    developer.setStatus(Status.DELETED);
                }
            }else {
                System.out.println("Умения с выбранным id нет.");
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return developer;
        }
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();
        String SQL = "SELECT * FROM developers";
        Developer developer = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                developer = new Developer(resultSet.getInt("id"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"),getSkills(),getSpecialty());
                if (resultSet.getBoolean("active")) {
                    developer.setStatus(Status.ACTIVE);
                } else {
                    developer.setStatus(Status.DELETED);
                }
                developers.add(developer);
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return developers;
        }
    }

    @Override
    public Developer save(Developer developer) {
        String SQL = "insert into developers (firstname,lastname,active) values (?,?,true)";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, developer.getFirstName());
            statement.setString(2,developer.getLastName());
            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return developer;
        }
    }

    @Override
    public Developer update(Developer developer) {
        String SQL = "UPDATE developers SET FIRSTNAME = ?,Lastname=? WHERE id = ?;";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1,developer.getFirstName());
            statement.setString(2,developer.getLastName());
            statement.setInt(3,developer.getId());

            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return developer;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        String SQL = "UPDATE developers SET ACTIVE = false WHERE id = ?";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1,integer);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Skill> getSkills(){
        String SQL = "SELECT skills.id, NAME " +
                "FROM developers " +
                "Inner JOIN skills " +
                "ON developers.ID = skills.DEVELOPER_ID;";
        Skill skill = null;
        List<Skill> skills = new ArrayList<>();
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                skill = new Skill(resultSet.getInt("id"), resultSet.getString("name"));
                skills.add(skill);
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return skills;
        }
    }

    public Specialty getSpecialty(){
        String SQL = "SELECT specialty.id, NAME \n" +
                "FROM developers \n" +
                "INNER JOIN specialty\n" +
                "ON developers.ID = specialty.DEVELOPER_ID;";
        Specialty specialty = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
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
}
