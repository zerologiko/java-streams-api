package lectures;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import com.google.common.collect.ImmutableList;

/**
 * Find the min and max with Comparators
 *
 */
public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    // with a custom Comparator
    Integer minManual = numbers.stream()
      .min((num1, num2) -> num1 > num2 ? 1 : -1)
      .get();

    assertThat(minManual).isEqualTo(1);
    System.out.println("Min manual comparator is: " + minManual);

    // with a "natural order" Comparator
    Integer minComparator = numbers.stream()
      .min(Comparator.naturalOrder())
      .get();

    assertThat(minComparator).isEqualTo(1);
    System.out.println("Min manual comparator is: " + minComparator);

  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

    // with a custom Comparator
    Integer maxManual = numbers.stream()
      .min((num1, num2) -> num1 < num2 ? 1 : -1)
      .get();

    assertThat(maxManual).isEqualTo(100);
    System.out.println("Max manual comparator is: " + maxManual);

    // with a "natural order" Comparator
    Integer maxComparator = numbers.stream()
      .max(Comparator.naturalOrder())
      .get();

    assertThat(maxComparator).isEqualTo(100);
    System.out.println("Max manual comparator is: " + maxComparator);

  }
}
