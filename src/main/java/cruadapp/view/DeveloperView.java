package cruadapp.view;

import cruadapp.controller.DeveloperController;
import cruadapp.controller.SkillController;
import cruadapp.controller.SpecialtyController;
import cruadapp.model.Developer;
import cruadapp.model.Skill;
import cruadapp.model.Specialty;
import cruadapp.repository.base.SpecialtyIml;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    Scanner scanner;
    private DeveloperController developerController = new DeveloperController();
    private SkillController skillController = new SkillController();
    private SpecialtyController specialtyController = new SpecialtyController();

    public void workProgram(){
        while (true){
            getAllDeveloper();
            writeNewDeveloper();
            updateDeveloper();
            deleteDeveloper();
            getAllDeveloper();
            break;
        }
    }
    private void writeNewDeveloper(){
        scanner = new Scanner(System.in);

        Developer developerToSave = new Developer();


        System.out.println("Введите firstName для Developer");
        String firstNameDeveloper = scanner.nextLine();
        developerToSave.setFirstName(firstNameDeveloper);

        System.out.println("Введите lastName для Developer");
        String lastNameDeveloper = scanner.nextLine();
        developerToSave.setLastName(lastNameDeveloper);


        List<Skill> skills = skillRead();
        developerToSave.setSkills(skills);

        Specialty specialty = specialtyRead();
        developerToSave.setSpecialty(specialty);

        developerController.create(developerToSave);
    }

    private void updateDeveloper(){
        scanner = new Scanner(System.in);
        Developer developerToSave = new Developer();


        System.out.println("Введите id Developer для обновления ");
        Integer id = scanner.nextInt();
        developerToSave.setId(id);

        System.out.println("Введите новое firstName Developer");
        String firstNameDeveloper = scanner.next();
        developerToSave.setFirstName(firstNameDeveloper);

        System.out.println("Введите новое lastName Developer");
        String lastNameDeveloper = scanner.nextLine();
        developerToSave.setLastName(lastNameDeveloper);


        developerController.update(developerToSave);
    }

    private void deleteDeveloper(){
        scanner = new Scanner(System.in);
        System.out.println("Введите id Developer для удаления");
        Integer id = scanner.nextInt();

        developerController.delete(id);
    }

    private void getAllDeveloper(){
        System.out.println(developerController.readAll());
    }

    private List<Skill> skillRead(){
        scanner = new Scanner(System.in);

        List<Skill> currentDeveloperSkills = new ArrayList<>();
        currentDeveloperSkills = developerController.getAllSkills();
        return currentDeveloperSkills;
    }

    private Specialty specialtyRead(){


        return developerController.getOneSpecialty();
    }
}
