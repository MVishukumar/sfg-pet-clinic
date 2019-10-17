package guru.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity {
    private String descirption;

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }
}
