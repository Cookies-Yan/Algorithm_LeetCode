package javaFoundation.objectOriented;

public class Teacher extends SingleDog {


    private String tech;

    public Teacher() {

    }

    public void tech() {

    }

    @Override
    public void work() {
        System.out.println("Teacher tech");
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
