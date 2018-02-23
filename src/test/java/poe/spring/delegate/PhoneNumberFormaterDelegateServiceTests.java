package poe.spring.delegate;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberFormaterDelegateServiceTests {

	@Test
	public void checkFormatOK() {
		String phone = "0600000000";
		String formated = PhoneNumberFormaterDelegateService.format(phone);
		assertThat(formated).isEqualTo(phone);
	}

	@Test
	public void checkFormat33() {
		assertThat(PhoneNumberFormaterDelegateService.format("+33600000000"))
				.isEqualTo("0600000000");
		assertThat(PhoneNumberFormaterDelegateService.format("+33700000000"))
				.isEqualTo("0700000000");
	}

	@Test
	public void checkFormat39() {
		assertThat(PhoneNumberFormaterDelegateService.format("+39600000000"))
				.isEqualTo("0600000000");

	}
}
