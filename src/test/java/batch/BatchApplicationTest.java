package batch;

import org.junit.runner.RunWith;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// NOTE: https://www.baeldung.com/spring-batch-testing-job

@ActiveProfiles("test")
@SpringBatchTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BatchApplication.class})
public interface BatchApplicationTest {}
