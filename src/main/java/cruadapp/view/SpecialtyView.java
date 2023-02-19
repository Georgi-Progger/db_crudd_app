package cruadapp.view;

import cruadapp.controller.DeveloperController;
import cruadapp.controller.SpecialtyController;
import cruadapp.model.Specialty;
import cruadapp.repository.base.SpecialtyIml;

import java.util.Scanner;

public class SpecialtyView {
    Scanner scanner;
    private SpecialtyController specialtyController = new SpecialtyController();
    private DeveloperController developerController = new DeveloperController();
    public void workProgram(){
        while (true){
            getAllSpeciality();
            writeNewSpecialty();
            updateSpecialty();
            deleteSpecialty();
            getAllSpeciality();
            break;
        }
    }
    private void writeNewSpecialty(){
        scanner = new Scanner(System.in);
        Specialty specialtyToSave = new Specialty();
        System.out.println("Введите новый id Specialty");
        Integer idSpecialty = scanner.nextInt();
        specialtyToSave.setId(idSpecialty);
        System.out.println("Введите название Specialty");
        String nameSpecialty = scanner.next();
        specialtyToSave.setName(nameSpecialty);

        System.out.println(developerController.readAll());
        System.out.println("Введите к какому разработчику отснести");
        Integer developerId = scanner.nextInt();
        specialtyToSave.setDeveloperId(developerId);
        specialtyController.create(specialtyToSave);

    }

    private void updateSpecialty(){
        scanner = new Scanner(System.in);
        System.out.println("Введите id Specialty для обновления ");
        Integer id = scanner.nextInt();
        System.out.println("Введите новое название Specialty");
        String nameSpecialty = scanner.next();
        Specialty specialtyToSave = new Specialty(id, nameSpecialty);

        specialtyController.update(specialtyToSave);
    }

    private void deleteSpecialty(){
        scanner = new Scanner(System.in);
        System.out.println("Введите id Specialty для удаления");
        Integer id = scanner.nextInt();

        specialtyController.delete(id);
    }

    private void getAllSpeciality(){
        System.out.println(specialtyController.readAll());
    }
}
