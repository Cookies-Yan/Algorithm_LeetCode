package algorithm.hash.hashCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * 对于hashcode来说我们每定义一个新的类，我们就要把equals和hashCode同步重写一遍
 */

public class HashCode {

    static class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //当不重写equals的时候，它并不认识student这个东西，无法判断它是否相等。
        //equals方法被重写，hashCode方法也尽量被重写
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }
        //当不重写HashCode的时候，它并不认识student这个东西，无法判断它是否相等。
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

    }

    public static void main(String[] args) {
        //HashCode相同，对象不一定相同，但对象在散列存储结构中，存于同一个位置中
        Student student1 = new Student("Cookies");
        Student student2 = new Student("Cookies");
        System.out.println(student1.equals(student2));

        HashMap<Student,Integer> map = new HashMap<>();
        map.put(student1,3);
        System.out.println(map.get(student2));

    }


}
