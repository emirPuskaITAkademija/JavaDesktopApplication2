package one.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InstanceMethodRefDemo {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(100,23, 34, 45, 67, 54);
        listOfNumbers.forEach(System.out::println);
        MojKomparator mojKomparator = new MojKomparator();
        //Lambda opet ovdje ništa ne radi..nego smao poziva drugu funkciju

        Comparator<Integer> komparator = (n1, n2)->mojKomparator.compare(n1, n2);
        //2. referenciranje na metodu nekog objekta ili instance
        Comparator<Integer> komparator2 = mojKomparator::compare;
        Collections.sort(listOfNumbers, mojKomparator::compare);
        System.out.println("Poslije sortiranj");
        listOfNumbers.forEach(System.out::println);
    }


    //static inner klase
    static class MojKomparator{
        //-1   0    1
        public int compare(Integer number1, Integer number2){
            return number2.compareTo(number1);
        }
    }
}
