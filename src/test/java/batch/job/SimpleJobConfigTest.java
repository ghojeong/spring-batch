package batch.job;

import batch.BatchTest;
import batch.TestApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {SimpleJobConfig.class, TestApplication.class})
public class SimpleJobConfigTest implements BatchTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @DisplayName("simpleJob 의 JobParameter 정상 출력 확인")
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
