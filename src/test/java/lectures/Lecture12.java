package lectures;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import beans.Person;
import mockdata.MockData;

/**
 * We used collectors, but how Collectors works under the hood?
 *
 */
public class Lecture12 {

  @Test
  public void understandingCollect() throws Exception {

    // Let's write a custom Collector like ".collect(Collectors.toList())"
    MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        // A collector will take three params:
        // 1) a Supplier  "() -> new ArrayList<String>()"
        // 2) a BiConsumer as accumulator "(list, elem) -> list.add(elem)"
        // 3) a BiCombiner as combiner "(list1, list2) -> list1.addAll(list2)"
        .collect(() -> new ArrayList<String>(), (list, elem) -> list.add(elem), (list1, list2) -> list1.addAll(list2));

    // ok understood, now just use method references refacrtoring with Eclipse:
    List<String> emails2 = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        // A collector will take three params:
        // 1) a Supplier  "ArrayList::new"
        // 2) a BiConsumer as accumulator "ArrayList::add"
        // 3) a BiCombiner as combiner "ArrayList::addAll"
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    emails2.forEach(System.out::println);

    // Q: why we need to provide a combiner for Lists??
    // A: for multithreading and parallel streams! :)

  }
}
