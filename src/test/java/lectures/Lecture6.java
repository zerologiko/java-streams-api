package lectures;


import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * FindAny and FindFirst differences
 *
 */
public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  // Q: Why we have two methods findAny() and findFirst()?
  // A: findFirst is DETERMINISTIC, and findAny is NOT DETERMINISTIC
  //    if you run in parallel, or some conditions findAny can return 6 or 7 or 8

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Integer any = Arrays.stream(numbers)
      .filter(numbersLessThan10)
      .findAny()
      .get();

    System.out.println(any);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Integer first = Arrays.stream(numbers)
      .filter(numbersLessThan10)
      .findFirst()
      .get();

    System.out.println(first);
  }
}

