package cruadapp.model;

public class Specialty {
    private Integer id;
    private String specName;
    private Status status = Status.ACTIVE;
    private Integer developerId;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return specName;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specName='" + specName + '\'' +
                ", status=" + status +
                '}';
    }

    public Specialty(){}
    public Specialty(Integer id, String name) {
        this.id = id;
        this.specName = name;
        this.status = Status.ACTIVE;
    }



    public void setId(Integer id) {
        this.id = id;
    }


    public void setName(String name) {
        this.specName = name;
    }



    public void setStatus(Status status) {
        this.status = status;
    }
}
