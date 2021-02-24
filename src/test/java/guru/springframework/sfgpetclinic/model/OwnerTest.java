package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

// Owner extends Person
class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Andre", "Felix");
        owner.setCity("Key West");
        owner.setTelephone("919191919");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Andre", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Felix", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("919191919", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Key West")); // HAMCREST example
    }
}