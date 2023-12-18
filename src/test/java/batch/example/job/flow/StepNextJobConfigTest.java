package batch.example.job.flow;

import batch.BatchTest;
import batch.TestApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {StepNextJobConfig.class, TestApplication.class})
public class StepNextJobConfigTest implements BatchTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @DisplayName("stepNextJob 의 3개의 step 확인")
    @Test
    public void simpleJob() throws Exception {
        assertThat(jobLauncherTestUtils.launchJob().getStatus())
                .isEqualTo(BatchStatus.COMPLETED);
    }
}
