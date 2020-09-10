package javaFoundation.objectOriented;

public class Coder extends SingleDog {
    private String time;

    private int salary;

    public Coder() {

    }

//    public Coder(String job, String time, int salary) {
//        super(job);
//        this.time = time;
//        this.salary = salary;
//    }
//
//    public Coder(String name, String gender, String job, String time, int salary) {
//        super(name, gender, job);
//        this.time = time;
//        this.salary = salary;
//    }

//    @Override
//    public Coder play() {
//        return new Coder();
//    }
//    public void play(){
//
//    }

    @Override
    public void work() {
        super.work();
        System.out.println("Coder work");
    }

    public void cs() {

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
