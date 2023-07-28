package com.webhook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebhookAppApplicationTests {

	@Test
	void contextLoads() {
		int i=0;
		assertEquals(0, i);
	}

}
