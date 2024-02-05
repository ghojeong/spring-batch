package batch.domain.version.job;

import batch.domain.version.repository.VersionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class VersionJobConfig {
    private final static String JOB_NAME = "versionJob";
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final VersionRepository versionRepository;

    @Bean
    public Job versionJob() {
        return jobBuilderFactory.get(JOB_NAME)
                .start(versionStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    @JobScope
    public Step versionStep() {
        return stepBuilderFactory.get("versionStep")
                .tasklet(((contribution, chunkContext) -> {
                    log.info(">>>>> This is Version Job");
                    log.info("Version: {}", versionRepository.findAll());
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
}
