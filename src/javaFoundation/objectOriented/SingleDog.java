package javaFoundation.objectOriented;

public class SingleDog {

    private String name;

    private String gender;

    private String job;

//    public static String time = "996";

    public void work(){
        System.out.println("Single Dog work");
    }

    public void play(){

    }
    static {
        System.out.println("static");
    }

    public SingleDog() {

    }

//    public SingleDog(String job) {
//        this.job = job;
//    }
//
//    public SingleDog(String name, String gender, String job) {
//        this.name = name;
//        this.gender = gender;
//        this.job = job;
//        {
//            System.out.println("constructor");
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
