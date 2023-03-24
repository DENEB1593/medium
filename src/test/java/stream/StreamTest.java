package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StreamTest {

  @Test
  void compareMapAndFlatMap() {
    List<User> users = given();

    // By Map
    List<List<String>> phoneListByMap = users.
            stream()
            .map(User::getPhones)
            .toList();

    System.out.println(phoneListByMap);

    // By FlatMap
    List<String> phoneListByFlatMap = users.stream()
            .flatMap(user -> user.getPhones().stream())
            .toList();
    System.out.println(phoneListByFlatMap);

    // assertion
    assertThat(phoneListByMap.get(0)).isInstanceOf(List.class);
    assertThat(phoneListByFlatMap.get(0)).isInstanceOf(String.class);

  }

  private static List<User> given() {
    return List.of(
            new User(1L, "kim", "kim@email.com", Arrays.asList("01012341234", "01012341234")),
            new User(2L, "park", "park@email.com", Arrays.asList("01012341235", "01012341235")),
            new User(3L, "lee", "lee@email.com", Arrays.asList("01012341236", "01012341236")),
            new User(4L, "hong", "hong@email.com", Arrays.asList("01012341237", "01012341237"))

    );

  }

}
