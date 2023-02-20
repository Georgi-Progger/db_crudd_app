package cruadapp.repository.base;

import cruadapp.model.Skill;
import cruadapp.model.Status;
import cruadapp.repository.SkillRepository;
import cruadapp.repository.base.util.Connect;
import cruadapp.service.SkillService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class SkillIml implements SkillRepository {

    public static SkillIml skillIml;
    private SkillIml() {
    }

    public static synchronized SkillIml getSkillIml(){
        if (skillIml == null){
            skillIml = new SkillIml();
        }
        return skillIml;
    }

    @Override
    public Skill getById(Integer integer){
        String SQL = "SELECT * FROM skills WHERE id = ?";
        Skill skill = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1,integer);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                skill = new Skill(resultSet.getInt("id"), resultSet.getString("name"));
                if (resultSet.getBoolean("active")) {
                    skill.setStatus(Status.ACTIVE);
                } else {
                    skill.setStatus(Status.DELETED);
                }
            }else {
                System.out.println("Умения с выбранным id нет.");
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return skill;
        }
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        String SQL = "SELECT * FROM skills";
        Skill skill = null;
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                skill = new Skill(resultSet.getInt("id"), resultSet.getString("name"));
                if (resultSet.getBoolean("active")) {
                    skill.setStatus(Status.ACTIVE);
                } else {
                    skill.setStatus(Status.DELETED);
                }
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

    @Override
    public Skill save(Skill skill) {
        String SQL = "insert into skills (name,active,developer_id) values (?,true,?)";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, skill.getName());
            statement.setInt(2,skill.getDeveloperId());
            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return skill;
        }
    }

    @Override
    public Skill update(Skill skill) {
        String SQL = "UPDATE skills SET NAME = ? WHERE id = ?";
        try(Connection connection = Connect.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1,skill.getName());
            statement.setInt(2,skill.getId());

            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return skill;
        }

    }

    @Override
    public void deleteById(Integer integer) {
        String SQL = "UPDATE skills SET ACTIVE = false WHERE id = ?";
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

