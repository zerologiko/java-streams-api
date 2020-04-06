package lectures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import beans.Person;
import mockdata.MockData;

/**
 * Introduction: first stream
 *
 */
public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();

    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    int i = 0;
    for (Person p : people) {
      if (p.getAge() <= 18) {
        System.out.println("[iterative]: " + p);
        i += 1;
      }
      if (i == 10) {
        break;
      }
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

    people.stream().filter(person -> person.getAge() <= 18)
      .limit(10)
      .collect(Collectors.toList())
      .forEach(System.out::println);

  }
}
