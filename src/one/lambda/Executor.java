package one.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// reference to an instance method of an arbitary object of particular type
public class Executor {
    public static void main(String[] args) {
        List<Person> listOfPersons = Arrays.asList(
                new Person("Mitar"),
                new Person("Amer"),
                new Person("Edin"),
                new Person("Aida"),
                new Person("Amila")
        );
        listOfPersons.forEach(p -> p.printName());//instancnu
        listOfPersons.forEach(Person::printName);

    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        //kakva je metoda ??
        //INSTANCNA
        public void printName() {
            System.out.println(name);
        }

        public static void printNameStatic(Person p){
            System.out.println(p);
        }
    }
}
