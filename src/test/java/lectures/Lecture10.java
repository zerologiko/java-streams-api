package lectures;


import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.Lists;

/**
 * Using flatMap to merge lists
 *
 */
public class Lecture10 {

  private static final List<List<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  @Before
  public void setUp() {
    System.out.println("Setup - Original list of lists: ");
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() throws Exception {
    // Combine all the names lists in a single list without using flatMap
    // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

    // For example, we can usa a reduction with an accumulator as a BinaryOperator
    BinaryOperator<List<String>> accumulator = (e1, e2) -> { e1.addAll(e2); return e1; };
    List<String> flattened = arrayListOfNames.stream().reduce(Lists.newArrayList(), accumulator);

    flattened.forEach(System.out::print);
  }

  @Test
  public void withFlatMap() throws Exception {
    // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]

    // with Lambda expression
    List<String> collected1 = arrayListOfNames
        .stream()
        .flatMap(t -> t.stream())
        .collect(Collectors.toList());

    // with method reference
    List <String> collected2 = arrayListOfNames.stream()
        .flatMap(List::stream)
        .collect(Collectors.toList());

    System.out.println(collected2);

  }

}

