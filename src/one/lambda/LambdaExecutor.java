package one.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <li>1. Prost tip</li>
 * <li>2. Objektne ili složene tipove</li>
 * <li>2.1 sirovi objektni </li>
 * <li>2.2 parametrizirane objektni tipovi</li>
 */
public class LambdaExecutor {
    /*
    1. Stream -> izvor streama
    2. STrema -> intermediate operations ili functions
    3. ne dobijem stream -> terminate operation ili funkcija terminira moj stream

     */
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> numberConsumer = t -> System.out.println(t);
        //Kada lambda ne radi ništa drugo nego samo poziva neku drugu funkciju
        //1. Referenciranje na statičku metodu
        for(Integer number: listOfNumbers){
            LambdaExecutor.consumeNumber(number);
        }

        listOfNumbers.forEach(LambdaExecutor::consumeNumber);

    }

    static void consumeNumber(int number) {
        System.out.println(number);
    }

    static void consumeNumbers(int... numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

}
