package zietek;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest(classes = SpringCloudContractProducerApplication.class)
public abstract class BaseTestClass {

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        log.info("==============START===================");
        RestAssuredMockMvc.webAppContextSetup(context);
        log.info("==============END===================");
    }

}
