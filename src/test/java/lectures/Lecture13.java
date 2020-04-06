package lectures;

import java.util.stream.Collectors;
import org.junit.Test;
import mockdata.MockData;

/**
 *
 * What's the difference betweend intermediate and terminal operators?
 *
 * Are streams lazy?
 *
 * What order the streams follows?
 *
 */
public class Lecture13 {
  @Test
  public void intermediateAndTerminalOperations() throws Exception {

    // lets print something to understand:
    System.out.println(
        MockData.getCars()
            // Here we go to "abstraction" of strams
            .stream()
            // This is an intermediate op because we stay in the abstraction
            .filter(car -> {
              System.out.println("filter car " + car);
              return car.getPrice() < 10000;
            })
            // This is intermediate too, we still working with streams "abstraction"
            .map(car -> {
              System.out.println("mapping car " + car);
              return car.getPrice();
            })
            // same as before, still intermediate, still in streams abstraction
            .map(price -> {
              System.out.println("mapping price " + price);
              return price + (price * .14);
            })
            // ok, this is a terminal operation and give you back the "concrete type" result of the operations
            .collect(Collectors.toList())
    );

    // Q: If you comment this line, no result is printed, you got only stram reference, why?
    // A: STREAMS are LAZY initialized

    // Q: What's the order of execution in the above code?
    // A: See the console print to understand order of execution:
    //    The mappings are executed as soon as the first car passes the filter
    //    so to get some results, stream don't need to filter ALL the list before

  }
}
