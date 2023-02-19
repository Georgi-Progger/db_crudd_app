package cruadapp.service;

import cruadapp.model.Developer;
import cruadapp.model.Skill;
import cruadapp.model.Specialty;
import cruadapp.repository.base.DeveloperIml;

import java.util.List;

public class DeveloperService implements GenericService<Developer,Integer>{

    private static DeveloperService developerService;

    private DeveloperService(){};

    public static DeveloperService getDeveloperService(){
        if (developerService == null){
            developerService = new DeveloperService();
        }
        return developerService;
    }
    @Override
    public Developer create(Developer developer) {
        DeveloperIml.getDeveloperIml().save(developer);
        return developer;
    }

    @Override
    public  Developer readOne(Integer integer) {
        return DeveloperIml.getDeveloperIml().getById(integer);
    }

    @Override
    public List<Developer> readAll() {
        return DeveloperIml.getDeveloperIml().getAll();
    }

    @Override
    public  void update(Developer developer) {
        DeveloperIml.getDeveloperIml().update(developer);
    }

    @Override
    public  void delete(Integer integer) {
        DeveloperIml.getDeveloperIml().deleteById(integer);
    }

    public List<Skill> allSkills(){
        return DeveloperIml.getDeveloperIml().getSkills();
    }
    public Specialty getSpecialty(){
        return DeveloperIml.getDeveloperIml().getSpecialty();
    }
}
