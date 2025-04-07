import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    interface Filter<T> {
        boolean apply(T o);
    }


    public static <T> T[] filter(T[] array, Filter<T> filter) {
        for(int i=0;i<array.length;i++){
            if (!filter.apply(array[i])) {
                array[i] = null;
            }
        }
        return array;
    }
    public static <T> T[] filter(T[] array, Predicate<T> predicate) {
        for(int i=0;i<array.length;i++){
            if (!predicate.test(array[i])) {
                array[i] = null;
            }
        }
        return array;
    }

    public static   <T> void fill(T[] array, Function<Integer,T> f){
        for (int i = 0; i < array.length; i++) {
            array[i] = f.apply(i);
        }
    }

    // Интерфейс Converter
    @FunctionalInterface
    interface Converter<T, N> {
        N convert(T t);

        static <T> boolean isNotNull(T t) {
            return t != null;
        }

        default void writeToConsole(T t) {
            if (isNotNull(t)) {
                System.out.println(t.toString());
            } else {
                System.out.println("Object is null");
            }
        }
    }


    // Класс Dog
    static class Dog {
        String name;
        int age;
        double weight;

        public Dog(String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Dog{name='" + name + "', age=" + age + ", weight=" + weight + "}";
        }
    }

    // Класс Cat
    static class Cat {
        String name;
        int age;
        double weight;

        public Cat(String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Cat{name='" + name + "', age=" + age + ", weight=" + weight + "}";
        }
    }

    static boolean  isOdd( Integer number,Predicate<Integer> pr){
        return pr.test(number);
    }

    public static void main(String[] args) {

        List<String> str = Arrays.asList("Apple", "AAA", "zzz", "bbb");
        str.sort(Comparator.comparingInt(String::length));
        //str.sort((s1,s2)->s1.length()-s2.length());
        System.out.println(str);

        String[] words = {"1", "2", "3", "44", "4", "555", "6","77"};
        System.out.println("Было  " + Arrays.toString(words));
        Filter<String> f = new Filter<>() {

            @Override
            public boolean apply(String o) {
                return o.length() <= 2;
            }
        };

        filter(words, f);
        System.out.println("Стало " + Arrays.toString(words));
        filter(words, (Predicate<String>) s-> s!=null && s.length()==1 );
        System.out.println("Стало " + Arrays.toString(words));

        Integer[] squares = new Integer[10];
        fill(squares, integer -> integer * integer);
        System.out.println("Массив после fill "+ Arrays.toString(squares));

        // Создание объекта Dog
        Dog dog = new Dog("Buddy", 5, 25.5);

        // Создание конвертера из Dog в Cat
        Converter<Dog, Cat> converter = x -> new Cat(x.name, x.age, x.weight);

        // Преобразование Dog в Cat
        Cat cat = converter.convert(dog);

        System.out.println("Конвертировали в  Cat: " + cat);

        Integer a=7;
        Predicate<Integer> pr=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer % 2==0);
            }
        };

        System.out.println("Число "+a+" Четное? "+isOdd(a,pr));

        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов


        List<String> nameList = new ArrayList<>();
        nameList.add("Elena");
        nameList.add("John");
        nameList.add("Alex");
        nameList.add("Jim");
        nameList.add("Sara");

        // Создание Supplier для получения случайного имени
        Supplier<String> randomNameSupplier = () -> {
            Random random = new Random();
            int index = random.nextInt(nameList.size());
            return nameList.get(index);
        };

        // Получение и вывод случайного имени
        String randomName = randomNameSupplier.get();
        System.out.println("Random Name: " + randomName);


    }
}
