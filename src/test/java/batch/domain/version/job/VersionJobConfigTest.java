package batch.domain.version.job;

import batch.BatchTest;
import batch.TestApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {VersionJobConfig.class, TestApplication.class})
class VersionJobConfigTest implements BatchTest {
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @DisplayName("versionJob 의 실행이 끝나면 status 가 COMPLETED 가 되어야 한다.")
    @Test
    public void versionJob() throws Exception {
        assertThat(jobLauncherTestUtils.launchJob().getStatus())
                .isEqualTo(BatchStatus.COMPLETED);
    }
}
