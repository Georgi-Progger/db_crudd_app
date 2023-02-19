package cruadapp.service;

import cruadapp.model.Skill;
import cruadapp.repository.GenericRepository;
import cruadapp.repository.SkillRepository;
import cruadapp.repository.base.SkillIml;

import java.sql.SQLException;
import java.util.List;

public class SkillService implements GenericService<Skill,Integer> {

    private static SkillService skillService;

    private SkillService(){};

    public static SkillService getSkillService(){
        if (skillService == null){
            skillService = new SkillService();
        }
        return skillService;
    }

    @Override
    public Skill create(Skill skill) {
        SkillIml.getSkillIml().save(skill);
        return skill;
    }

    @Override
    public  Skill readOne(Integer integer) {
        return SkillIml.getSkillIml().getById(integer);
    }

    @Override
    public List<Skill> readAll() {
        return SkillIml.getSkillIml().getAll();
    }

    @Override
    public void update(Skill skill) {
        SkillIml.getSkillIml().update(skill);
    }

    @Override
    public void delete(Integer integer) {
        SkillIml.getSkillIml().deleteById(integer);
    }


}
