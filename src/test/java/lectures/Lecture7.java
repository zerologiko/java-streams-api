package lectures;


import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import beans.Car;
import beans.Person;
import mockdata.MockData;

/**
 * Filtering and count
 *
 */
public class Lecture7 {

  // it's ok also Predicate<Person>, expliciting <? super Person> just to remember the possibility
  private Predicate<? super Person> femalePredicate = p -> p.getGender().equalsIgnoreCase("female");

  @Test
  public void count() throws Exception {

    // Count all the females
    ImmutableList<Person> people = MockData.getPeople();

    long count = people.stream()
        .filter(femalePredicate)
        .count();

    System.out.println("Female count is: " + count);
    assertThat(count).isEqualTo(467);
  }

  @Test
  public void min() throws Exception {

    //Calculate the min and max without Comparators

    // using a map reduce
    Double minPrice1 = MockData.getCars()
      .stream()
      .mapToDouble(Car::getPrice)
      .reduce((e1, e2) -> e1 < e2 ? e1 : e2)
      .getAsDouble();

    System.out.println("Min price using map & reduce is: " + minPrice1);

    // BETTER using a map and min, also only yellow cars :)
    // also using orElse to get a default if list empty
    Double minPrice2 = MockData.getCars()
      .stream()
      .filter(c -> c.getColor().equalsIgnoreCase("yellow"))
      .mapToDouble(Car::getPrice)
      .min()
      .orElse(0);

    System.out.println("Min price of yellow cars is: " + minPrice2);
  }

  @Test
  public void max() throws Exception {

    // BETTER using a map and ...min :)
    Double max = MockData.getCars()
      .stream()
      .mapToDouble(Car::getPrice)
      .max()
      .getAsDouble();

    System.out.println("Max price using map & min is: " + max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();

    //Let's try with an empty List
    ImmutableList<Car> emptyCars = ImmutableList.of();;

    Double average = emptyCars
        .stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

    System.out.println("Average price of empty list is: " + average);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream().mapToDouble(Car::getPrice).sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics =
        cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}
