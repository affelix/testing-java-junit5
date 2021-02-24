package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}") // placeholders
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String valueSource) {
        System.out.println(valueSource);
    }

    /**
     * Iterate over enumeration of OwnerType
     * @param ownerType
     */
    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}") // placeholders
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    /**
     * Comma separated values
     */
    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}") // placeholders
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 1, 1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }
}