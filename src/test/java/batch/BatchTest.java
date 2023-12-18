package batch;

import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

// NOTE: https://docs.spring.io/spring-batch/docs/4.2.x/reference/html/testing.html#endToEndTesting
// NOTE: https://www.baeldung.com/spring-batch-testing-job

@ActiveProfiles("test")
@SpringBatchTest
@Sql(
        scripts = {"classpath:schema.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public interface BatchTest {}
