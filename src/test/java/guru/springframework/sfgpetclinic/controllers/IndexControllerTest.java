package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returne for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned"); // with error message

        assertThat(controller.index()).isEqualTo("index"); //AssertJ !! Alternative to JUnit, to more granular tests
    }

    @Test
    @DisplayName("Test Exception")
        // it is not widely used, but may come in handy
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Test
    @Disabled
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here");
        });
    }


    @Test
    @Disabled
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here prempt");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("guru"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS) // only this one will run in my current PC
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "laptop-jtabtvqm\\andre")
    void testIfUserAndre() {

    }
}