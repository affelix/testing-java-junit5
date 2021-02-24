package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // to allow the test to run, because usually the test is static
@Tag("controllers")
public interface ControllerTests {

    @BeforeAll
    default void beforeAll() {
        System.out.println("Let's do something here");
    }
}
