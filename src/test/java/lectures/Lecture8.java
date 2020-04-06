package lectures;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.assertj.core.util.Lists;
import org.junit.Test;
import beans.Car;
import mockdata.MockData;

/**
 * Grouping and counting (SQL Like)
 *
 */
public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> carByMaker = MockData.getCars()
      .stream()
      .collect(Collectors.groupingBy(Car::getMake));

    // print using a BiConsumer
    carByMaker.forEach( (make, cars) -> {
      System.out.println("maker: " + make);
      cars.forEach(System.out::println);
    });

  }

  @Test
  public void groupingAndCounting() throws Exception {

    // let's try to count occurences of a list
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

    //We can use a Function.identity() and a Collectors.counting() to groupBy
    Map<String, Long> groupAndCounting = names.stream()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    groupAndCounting.forEach( (name, count) -> System.out.print("Name: " + name + " count: " + count));

  }

}