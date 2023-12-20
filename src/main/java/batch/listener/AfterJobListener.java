package batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AfterJobListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("JOB 수행완료 {}", jobExecution);

        final String message = jobExecution.getStatus().equals(BatchStatus.COMPLETED)
                ? "성공 슬랙 배치"
                : "실패 슬랙 배치";
        log.info(message);
    }
}
