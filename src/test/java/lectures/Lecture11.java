package lectures;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import com.google.common.collect.ImmutableList;

/**
 * Joining strings using reduce and Collector
 *
 */
public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    // ket's try to concatenate all the strings with a semicolon using reduce
    String concatReduce = names.stream().reduce("", (e1, e2) -> e1.concat(e2).concat(";"));
    System.out.println("Concatenated reduce: " + concatReduce);

    // easier using a specilized collector
    String concatCollect = names.stream().collect(Collectors.joining(";"));
    System.out.println("Concatenated collect: " + concatCollect);

  }
}
