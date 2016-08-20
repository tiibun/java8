package sample5;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Sample1 {

  static class Member {
    String name;

    Member(String name) {
      this.name = name;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }

    @Override
    public String toString() {
      return "Member[" + name + "]";
    }
  }

  static class Group {
    List<Member> members;
    String name;

    Group(String name, List<Member> members) {
      this.name = name;
      this.members = members;
    }

    @Override
    public String toString() {
      return "Group[" + name + "]";
    }
  }

  List<Member> members = Arrays.asList(new Member("Taku"), new Member("Shin"), new Member("Tsuyo"),
      new Member("Masa"), new Member("Goro"));

  List<Group> groups = Arrays.asList(new Group("ZMAP", Arrays.asList(new Member("Taku"))));

  Optional<Member> getMember(String name) {
    return members.stream().filter(m -> Objects.equals(m.name, name)).findAny();
  }

  Optional<Group> getGroup(Member member) {
    return groups.stream().filter(g -> g.members.contains(member)).findAny();
  }

  public static void main(String[] args) {
    Sample1 sample1 = new Sample1();
    sample1.exec("Goro");
    sample1.exec("Taku");
  }
  
  void exec(String name) {
    Optional<Group> group = this.getMember(name)
      .flatMap(m -> getGroup(m));
    
    System.out.println(group);
  }
}
