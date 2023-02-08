package cruadapp.repository.base;

import cruadapp.model.Developer;
import cruadapp.repository.DeveloperRepository;

import java.util.List;

public class DeveloperIml implements DeveloperRepository {

    private List<Developer> readDeveloperFromFile() {
        return null;
    }
    private void writeDeveloperToFile(List<Developer> developers) {

    }


    @Override
    public Developer getById(Integer integer) {
        return null;
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public Developer save(Developer developer) {
        return null;
    }

    @Override
    public Developer update(Developer developer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
