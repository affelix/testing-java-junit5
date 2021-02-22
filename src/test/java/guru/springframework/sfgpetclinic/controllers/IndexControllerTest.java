package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    @DisplayName("Test Exception") // it is not widely used, but may come in handy
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()), "This is some expensive " +
                "Message to build" +
                " for my test"); // not usually used in this context, but still used in the next topic (48); of the course
    }
}