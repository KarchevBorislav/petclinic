package spring.framework.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;
import static org.junit.jupiter.api.Assertions.*;
import static spring.framework.petclinic.controllers.ErrorController.URL_OUPS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
class ErrorControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ErrorController()).build();
    }

    @Test
    void triggerExceptionTest() {
        assertThrows(RuntimeException.class, () -> mockMvc.perform(get(URL_OUPS)));
    }
}