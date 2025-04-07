import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JosephusProblem {
    // Driver code
    public static void main(String [] args)
    {
        int n = 14; // specific n and k  values for original
        // josephus problem
        int k = 2;
        k--; // (k-1)th person will be killed
        int index = 0; // The index where the person which will die

        List<Integer> person = new ArrayList<>();

        // fill the person vector
        for (int i = 1; i <= n; i++) {
            person.add(i);
        }

        Josh(person, k, index);
        List<Integer> personLinkedList = new LinkedList<>();

        // fill the person vector
        for (int i = 1; i <= n; i++) {
            personLinkedList.add(i);
        }

        Josh(personLinkedList, k, index);

        MyArrayList<Integer> myListPerson = new MyArrayList<>();

        // fill the person vector
        for (int i = 1; i <= n; i++) {
            myListPerson.add(i);
        }

        JoshWithMy(myListPerson, k, index);

        List<Integer> pers = new MyNewArrayList<>();

        // fill the person vector
        for (int i = 1; i <= n; i++) {
            pers.add(i);
        }

        Josh(pers, k, index);
    }
    static void Josh(List<Integer> person, int k, int index)
    {

        // Base case , when only one person is left
        if (person.size() == 1) {
            System.out.println(person.get(0));
            return;
        }

        // find the index of first person which will die
        index = ((index + k) % person.size());

        // remove the first person which is going to be killed
        person.remove(index);

        // recursive call for n-1 persons
        Josh(person, k, index);
    }
    static void JoshWithMy(MyArrayList<Integer> person, int k, int index)
    {

        // Base case , when only one person is left
        if (person.size() == 1) {
            System.out.println(person.get(0));
            return;
        }

        // find the index of first person which will die
        index = ((index + k) % person.size());

        // remove the first person which is going to be killed
        person.remove(index);

        // recursive call for n-1 persons
        JoshWithMy(person, k, index);
    }

}
