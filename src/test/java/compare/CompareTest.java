package compare;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompareTest {

  @Test
  void compareStudentAge() {
    List<Student> students = given();


    // comparable 구현체를 활용한 경우, 해당 객체의 compareTo를 구현한다.
    // Comparable의 경우 별도의 타입 제너릭을 지정하지 않으면 Object로 지정되니
    // 엄격한 타입검사를 위해 별도로 제너릭 타입을 지정한다.
    List<Student> sortByRule = students.stream()
        .sorted()
        .toList();

    assertThat(sortByRule.get(0).getName()).isEqualTo("ahn");
    assertThat(sortByRule.get(sortByRule.size() - 1).getName()).isEqualTo("kim");
  }

  private static List<Student> given() {
    return List.of(
        new Student("kim", 31),
        new Student("jeong", 24),
        new Student("kim", 45),
        new Student("lee", 17),
        new Student("ahn", 17),
        new Student("park", 19),
        new Student("choi", 18)
    );
  }

  // 일급객체로 활용이 가능하며, Student가 가지는 객체를 건들지 않고 별도로 생성가능한 방법이다.
  private static Comparator<Student> studentComparator =
      (s1, s2) -> s1.compareTo(s2);

}
