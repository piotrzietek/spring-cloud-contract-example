package zietek.contract;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import zietek.BaseTestClass;


public class EvenOddTest extends BaseTestClass {

    @Autowired
    private EvenOddController evenOddController;

    @BeforeEach
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(
                evenOddController
        );
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}