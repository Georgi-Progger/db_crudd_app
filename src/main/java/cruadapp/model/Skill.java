package cruadapp.model;

public class Skill {
    private Integer id;
    private String name;
    private Status status;
    private Integer developerId;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Skill(){}
    public Skill(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.status = Status.ACTIVE;
    }


    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
