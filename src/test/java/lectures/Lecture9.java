package lectures;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import org.junit.Test;

/**
 * Using reduce (a fold operation)
 *
 */
public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

    // using a lambda
    Integer sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b);

    // or using Integer sum method reference
    Integer sumAlternative = Arrays.stream(integers).reduce(0, Integer::sum);

    System.out.println("Sum is: " + sum);
    System.out.println("Sum alternative is:" + sumAlternative);

    assertThat(sum)
      .isEqualTo(sumAlternative)
      .isEqualTo(1831);

  }


}

