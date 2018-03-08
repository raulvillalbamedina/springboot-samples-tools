package es.rvillalba.spring.async.context;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import es.rvillalba.spring.unittest.context.AbstractSpringContext;

@ActiveProfiles("dev")
public class SpringContextIT extends AbstractSpringContext {
	@Test
	public void testContext() {
	}
}
