package cruadapp.service;

import cruadapp.model.Specialty;
import cruadapp.repository.base.SpecialtyIml;

import java.util.List;

public class SpecialtyService implements GenericService<Specialty,Integer>{
    private static SpecialtyService specialtyService;

    private SpecialtyService(){};

    public static SpecialtyService getSpecialtyService(){
        if (specialtyService == null){
            specialtyService = new SpecialtyService();
        }
        return specialtyService;
    }

    @Override
    public Specialty create(Specialty specialty) {
        SpecialtyIml.getSpecialtyIml().save(specialty);
        return specialty;
    }

    @Override
    public Specialty readOne(Integer integer) {
        return SpecialtyIml.getSpecialtyIml().getById(integer);
    }

    @Override
    public List<Specialty> readAll() {
        return SpecialtyIml.getSpecialtyIml().getAll();
    }

    @Override
    public void update(Specialty specialty) {
        SpecialtyIml.getSpecialtyIml().update(specialty);
    }

    @Override
    public void delete(Integer integer) {
        SpecialtyIml.getSpecialtyIml().deleteById(integer);
    }
}
