package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PasswordEncodeTest {

	@Test
	public void 암호화() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String result = encoder.encode("1234");
		assertTrue(encoder.matches("1234", result));
		System.out.println(result);
	}
}
