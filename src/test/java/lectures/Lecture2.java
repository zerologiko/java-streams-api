package lectures;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;
import beans.Person;
import mockdata.MockData;

/**
 * Using range to generate number sequences
 *
 */
public class Lecture2 {

  @Test
  public void range() throws Exception {

    //esclusive with a lambda
    System.out.println("esclusive:");
    IntStream.range(0, 10).forEach(index -> System.out.println(index));

    // or inclusive with "method reference" more compact
    System.out.println("inclusive:");
    IntStream.rangeClosed(0, 10).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    // just to test IntRange... it can be done with a simple forEach on the people stream
    System.out.println("iterate over people:");
    IntStream.range(0, people.size())
      .forEach(index -> {
        Person person = people.get(index);
        System.out.println(index + ": " + person);
      });

  }

  @Test
  public void intStreamIterate() throws Exception {

      // create an iterator with a defined step
      IntStream.iterate(0, operand -> operand + 1)
          .filter(number -> number % 2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }
}
