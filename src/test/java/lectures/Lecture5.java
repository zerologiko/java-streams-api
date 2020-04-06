package lectures;


import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import beans.Car;
import beans.Person;
import beans.PersonDTO;
import mockdata.MockData;

/**
 * Filtering with Predicates
 * Mapping
 */
public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<? super Car> cheapCarsPredicate = car -> car.getPrice() < 9999;

    List<Car> filteredCars = cars.stream()
      .filter(cheapCarsPredicate)
      .collect(Collectors.toList());

    filteredCars.forEach(System.out::println);

  }

  @Test
  public void firstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    // long version with an lambda function defined before
    Function<? super Person, ? extends PersonDTO> personToDtoFunction = p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge());
    List<PersonDTO> dtosLongVersion = people.stream()
      .map(personToDtoFunction).collect(Collectors.toList());

    // short version with a method reference
    List<PersonDTO> dtos = people.stream()
      .map(PersonDTO::map)
      .collect(Collectors.toList());

    dtos.forEach(System.out::println);
    assertThat(people.size()).isEqualTo(dtos.size());
  }

  @Test
  public void averageCarPrice() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Double average = cars.stream()
      .mapToDouble(Car::getPrice)
      .average()
      .orElse(0D);

    System.out.println("Price average: " + average.doubleValue());
  }

}



