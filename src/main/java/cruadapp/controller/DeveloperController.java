package cruadapp.controller;

import cruadapp.model.Developer;
import cruadapp.model.Skill;
import cruadapp.model.Specialty;
import cruadapp.repository.DeveloperRepository;
import cruadapp.service.DeveloperService;
import cruadapp.service.GenericService;

import java.util.List;

public class DeveloperController implements GenericController<Developer, Integer> {


    @Override
    public Developer create(Developer developer) {
        DeveloperService.getDeveloperService().create(developer);
        return developer;
    }

    @Override
    public Developer read(Integer integer) {
        return DeveloperService.getDeveloperService().readOne(integer);
    }

    @Override
    public List<Developer> readAll() {
        return DeveloperService.getDeveloperService().readAll();
    }

    @Override
    public void update(Developer developer) {
        DeveloperService.getDeveloperService().update(developer);
    }

    @Override
    public void delete(Integer integer) {
        DeveloperService.getDeveloperService().delete(integer);
    }

    public List<Skill> getAllSkills(){
        return DeveloperService.getDeveloperService().allSkills();
    }

    public Specialty getOneSpecialty(){
        return DeveloperService.getDeveloperService().getSpecialty();
    }

}
