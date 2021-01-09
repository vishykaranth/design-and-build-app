package lamdba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("Ashok", "Ram", 21);
        Person person2 = new Person("Sita", "Nitin", 33);
        Person person3 = new Person("Sudershan", "Krishna", 41);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        for(Person p : personList){
            p.printName();
        }

        //Ascending Order
        Collections.sort(personList, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));

        for (Person p: personList){
            p.printName();
        }

        Collections.sort(personList, (Person p1, Person p2) -> p2.getLastName().compareTo(p1.getLastName()));

        for (Person p: personList){
            p.printName();
        }

    }
}
