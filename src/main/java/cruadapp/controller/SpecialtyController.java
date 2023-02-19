package cruadapp.controller;

import cruadapp.model.Developer;
import cruadapp.model.Specialty;
import cruadapp.service.GenericService;
import cruadapp.service.SpecialtyService;

import java.util.List;

public class SpecialtyController implements GenericController<Specialty, Integer> {

    @Override
    public Specialty create(Specialty specialty) {
        SpecialtyService.getSpecialtyService().create(specialty);
        return specialty;
    }

    @Override
    public Specialty read(Integer integer) {
        return SpecialtyService.getSpecialtyService().readOne(integer);
    }

    @Override
    public List<Specialty> readAll() {
        return SpecialtyService.getSpecialtyService().readAll();
    }

    @Override
    public void update(Specialty specialty) {
        SpecialtyService.getSpecialtyService().update(specialty);
    }

    @Override
    public void delete(Integer integer) {
        SpecialtyService.getSpecialtyService().delete(integer);
    }
}
