package stream;

import java.util.List;

public class User {

  private Long id;

  private String name;

  private String email;

  private List<String> phones;

  public User() {
  }

  public User(Long id, String name, String email, List<String> phones) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phones = phones;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getPhones() {
    return phones;
  }

  public void setPhones(List<String> phones) {
    this.phones = phones;
  }


  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phones=" + phones +
            '}';
  }
}
