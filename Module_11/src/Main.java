
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<String> list = new ArrayList<>();
        list.add("A");
        List<String> copy = list; // Копируется ссылка, а не объект!
        copy.add("B");            // Изменяется исходный список.
        System.out.println(list); // [A, B]
        Example ex= new Example(1,2,3,4);
        System.out.format("a=%d, d=%d, c=%d",ex.a,ex.d,ex.c);
        Child child1= new Child();
        child1.test();
    }
}
class Example {
    public int a;     // Доступен всем
    private int b;    // Только внутри класса
    protected int c;  // Класс, наследники, пакет
    int d;            // Только внутри пакета

    public Example(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}



class Parent {
    void defaultMethod() {
        System.out.println("defaultMethod");
    }    // default-доступ
    protected void protMethod() {System.out.println("protMethod");} // protected-доступ
}


class Child extends Parent {
    void test() {
        defaultMethod(); // Ошибка! default-метод невидим в другом пакете.
        protMethod();    // Доступно (protected).
    }
}