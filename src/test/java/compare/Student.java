package compare;

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
}
