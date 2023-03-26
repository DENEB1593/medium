package combinelist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CombineListTest {

  private List<String> list1 = List.of("a", "b", "c");
  private List<String> list2 = List.of("c", "d", "f");

  @Test
  void option_01() {
    // using for - loop
    List<String> merge = new ArrayList<>();
    int i;
    for(i=0;i<Math.min(list1.size(), list2.size());i++){
      merge.add(list1.get(i));
      merge.add(list2.get(i));
    }

    if(list1.size() > list2.size()){
      for(int j=i;j<list1.size();j++){
        merge.add(list1.get(j));
      }
    }else {
      for(int j=i;j<list2.size();j++){
        merge.add(list2.get(j));
      }
    }

    assertThat(merge).hasSize(6);
  }

  @Test
  void option_02() {
    // Collection addAll
    List<String> merge = new ArrayList<>();
    merge.addAll(list1);
    merge.addAll(list2);
    assertThat(merge).hasSize(6);
  }

  @Test
  void option_03() {
    // using stream
    List<String> merge = List.of(list1, list2)
            .stream()
            .flatMap(List::stream)
            .toList();

    assertThat(merge).hasSize(6);
  }

  @Test
  void option_04() {
    List<String> merge = List.of(list1, list2).stream()
            .flatMap(List::stream)
            .distinct()
            .collect(Collectors.toList());

    assertThat(merge).hasSize(5);

  }

  /**
   * 별도의 함수를 생성하여 List 파라미터 개수를 동적으로 지정하여 진행할 수 있다.
   * 다수함수 및 StreamFlatMap을 활용한다.
   */
  private static List<String> getLists(List<String> ... lists) {
    return Arrays.stream(lists)
            .flatMap(List::stream)
            .toList();

  }


}
