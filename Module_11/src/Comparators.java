import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparators {

    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person other) {
            int nameCompare = this.name.compareTo(other.name);
            return (nameCompare != 0) ? nameCompare : Integer.compare(this.age, other.age);
        }

        @Override
        public String toString() {
            return String.format("%s,\"%d\"", name, age);
        }
    }

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Абу", 12));
        persons.add(new Person("Майя", 16));
        persons.add(new Person("Витя", 22));
        persons.add(new Person("Вова", 121));
        persons.add(new Person("Дима", 2));
        persons.add(new Person("Абу_1", 12));
        persons.add(new Person("Майя_1", 16));
        persons.add(new Person("Витя_1", 22));
        persons.add(new Person("Вова_1", 121));
        persons.add(new Person("Дима_1", 2));
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        System.out.println(persons);
        persons.sort(comparator);
        System.out.println(persons);
        persons.sort(Comparator.comparing(Person::getAge));
        //persons.sort( );
        System.out.println(persons);


    }
}
