package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// What is really cool w.r.t. to assertAll is that it allows to write multiple tests within an assertion.
// And still manages to run the assertions after one fails.
class PersonTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1L, "Joe", "Buck");

        //then
        assertAll("Test Props set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1L, "Joe", "Buck");

        //then
        assertAll("Test Props set",
                () -> assertEquals(person.getFirstName(), "Joe2", "First name failed"),
                () -> assertEquals(person.getLastName(), "Buckxx", "Last name failed"));
    }
}