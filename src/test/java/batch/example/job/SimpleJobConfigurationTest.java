package batch.example.job;

import batch.BatchApplicationTest;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

// NOTE: https://www.baeldung.com/spring-batch-testing-job

public class SimpleJobConfigurationTest implements BatchApplicationTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @After
    public void cleanUp() {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Test
    public void simpleJob() throws Exception {
        // given
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("requestDate", "20180815");

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(
                builder.toJobParameters()
        );

        // then
        assertThat(jobExecution.getStatus())
                .isEqualTo(BatchStatus.COMPLETED);
    }

}
