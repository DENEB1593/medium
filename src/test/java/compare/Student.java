package compare;

import java.util.Objects;

public class Student implements Comparable<Student> {
  private String name;
  private int age;

  public Student() {
  }

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }


  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  // 학생의 정렬 기준은 나이 순으로 한다.
  // 나이가 동일한 경우 문자를 오름 차순 정렬로 지정한다
  @Override
  public int compareTo(Student that) {
    if (this.age == that.getAge()) {
      return this.name.compareTo(that.getName());
    }

    return this.age > that.age ? 1 : -1;
  }

  // https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return age == student.age && Objects.equals(name, student.name);
  }

  // hashCode의 경우 HashMap등에서 활용한다.
  // 별도의 @Override를 하는 것도 좋다.
  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
