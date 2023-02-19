package cruadapp.controller;

import cruadapp.model.Developer;
import cruadapp.model.Skill;
import cruadapp.service.GenericService;
import cruadapp.service.SkillService;

import java.util.List;

public class SkillController implements GenericController<Skill, Integer>{

    @Override
    public Skill create(Skill skill) {
        SkillService.getSkillService().create(skill);
        return skill;
    }

    @Override
    public Skill read(Integer integer) {
        return SkillService.getSkillService().readOne(integer);
    }

    @Override
    public List<Skill> readAll() {
        return SkillService.getSkillService().readAll();
    }

    @Override
    public void update(Skill skill) {
        SkillService.getSkillService().update(skill);
    }

    @Override
    public void delete(Integer integer) {
        SkillService.getSkillService().delete(integer);
    }
}
