package zietek.contract;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
@AutoConfigureStubRunner(
		ids = "zietek:spring-cloud-contract-producer:+:stubs:8091",
		stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class SpringCloudContractConsumerApplicationTest {

	@Test
	public void given_WhenPassEvenNumberInQueryParam_ThenReturnEven() {
		// given:
		RestTemplate restTemplate = new RestTemplate();
		
		// when:
		ResponseEntity<String> response =
				restTemplate.getForEntity("http://localhost:8091/api/validate/number?number=2", String.class);
		
		// then:
		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody()).isEqualTo("Even");
	}

	@Test
	public void given_WhenPassOddNumberInQueryParam_ThenReturnOdd() {
		// given:
		RestTemplate restTemplate = new RestTemplate();

		// when:
		ResponseEntity<String> response =
				restTemplate.getForEntity("http://localhost:8091/api/validate/number?number=1", String.class);

		// then:
		assertThat(response.getStatusCode()).isEqualTo(OK);
		assertThat(response.getBody()).isEqualTo("Odd");
	}

}
