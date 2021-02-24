package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// What is really cool w.r.t. to assertAll is that it allows to write multiple tests within an assertion.
// And still manages to run the assertions after one fails.
class PersonTest implements ModelTests {

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
                () -> assertEquals("Joe", person.getFirstName(), "First name failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last name failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        //todo - implement this test
    }

    // Dependency Injection of JUnit
    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myAssignmentRepeatedTest() {
        //todo - implement this test
    }


}

