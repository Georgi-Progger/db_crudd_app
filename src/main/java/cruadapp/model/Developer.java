package cruadapp.model;

import java.util.List;

public class Developer {
    private Status status = Status.ACTIVE;
    private String firstName;
    private Integer id;
    private String lastName;
    private List<Skill> skills;
    private Specialty specialty;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", skills=" + skills +
                ", specialty=" + specialty +
                '}';
    }

    public Developer(){}
    public Developer(int id, String firstName, String lastName, List<Skill> skills, Specialty specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.status = Status.ACTIVE;
        this.specialty = specialty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSkills(List<Skill> skill) {
        this.skills = skill;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
