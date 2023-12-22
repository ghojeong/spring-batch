-- >> Spring Batch
DROP TABLE IF EXISTS `BATCH_STEP_EXECUTION_CONTEXT`;
DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION_CONTEXT`;
DROP TABLE IF EXISTS `BATCH_STEP_EXECUTION`;
DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION_PARAMS`;
DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION`;
DROP TABLE IF EXISTS `BATCH_JOB_INSTANCE`;

DROP TABLE IF EXISTS `BATCH_STEP_EXECUTION_SEQ`;
DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION_SEQ`;
DROP TABLE IF EXISTS `BATCH_JOB_SEQ`;
DROP SEQUENCE IF EXISTS `BATCH_STEP_EXECUTION_SEQ`;
DROP SEQUENCE IF EXISTS `BATCH_JOB_EXECUTION_SEQ`;
DROP SEQUENCE IF EXISTS `BATCH_JOB_SEQ`;

CREATE SEQUENCE BATCH_JOB_SEQ START WITH 1 MINVALUE 1 INCREMENT BY 1;
CREATE SEQUENCE BATCH_JOB_EXECUTION_SEQ START WITH 1 MINVALUE 1 INCREMENT BY 1;
CREATE SEQUENCE BATCH_STEP_EXECUTION_SEQ START WITH 1 MINVALUE 1 INCREMENT BY 1;

CREATE TABLE `BATCH_JOB_INSTANCE`
(
    `JOB_INSTANCE_ID` INT UNSIGNED NOT NULL PRIMARY KEY,
    `VERSION`         INT UNSIGNED,
    `JOB_NAME`        VARCHAR(100) NOT NULL,
    `JOB_KEY`         VARCHAR(32)  NOT NULL,
    CONSTRAINT `JOB_INST_UN` UNIQUE (`JOB_NAME`, `JOB_KEY`)
);

CREATE TABLE `BATCH_JOB_EXECUTION`
(
    `JOB_EXECUTION_ID`           INT UNSIGNED NOT NULL PRIMARY KEY,
    `VERSION`                    INT UNSIGNED,
    `JOB_INSTANCE_ID`            INT UNSIGNED NOT NULL,
    `CREATE_TIME`                DATETIME     NOT NULL,
    `START_TIME`                 DATETIME,
    `END_TIME`                   DATETIME,
    `STATUS`                     VARCHAR(10),
    `EXIT_CODE`                  VARCHAR(2500),
    `EXIT_MESSAGE`               VARCHAR(2500),
    `LAST_UPDATED`               DATETIME,
    `JOB_CONFIGURATION_LOCATION` VARCHAR(2500),
    CONSTRAINT `JOB_INST_EXEC_FK` FOREIGN KEY (`JOB_INSTANCE_ID`) REFERENCES `BATCH_JOB_INSTANCE` (`JOB_INSTANCE_ID`)
);

CREATE TABLE `BATCH_JOB_EXECUTION_PARAMS`
(
    `JOB_EXECUTION_ID` INT UNSIGNED NOT NULL,
    `TYPE_CD`          VARCHAR(6)   NOT NULL,
    `KEY_NAME`         VARCHAR(100) NOT NULL,
    `STRING_VAL`       VARCHAR(250),
    `DATE_VAL`         DATETIME,
    `LONG_VAL`         BIGINT,
    `DOUBLE_VAL`       DOUBLE,
    `IDENTIFYING`      CHAR(1)      NOT NULL,
    CONSTRAINT `JOB_EXEC_PARAMS_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `BATCH_JOB_EXECUTION` (`JOB_EXECUTION_ID`)
);

CREATE TABLE `BATCH_STEP_EXECUTION`
(
    `STEP_EXECUTION_ID`  INT UNSIGNED NOT NULL PRIMARY KEY,
    `VERSION`            INT UNSIGNED NOT NULL,
    `STEP_NAME`          VARCHAR(100) NOT NULL,
    `JOB_EXECUTION_ID`   INT UNSIGNED NOT NULL,
    `START_TIME`         DATETIME     NOT NULL,
    `END_TIME`           DATETIME,
    `STATUS`             VARCHAR(10),
    `COMMIT_COUNT`       INT UNSIGNED,
    `READ_COUNT`         INT UNSIGNED,
    `FILTER_COUNT`       INT UNSIGNED,
    `WRITE_COUNT`        INT UNSIGNED,
    `READ_SKIP_COUNT`    INT UNSIGNED,
    `WRITE_SKIP_COUNT`   INT UNSIGNED,
    `PROCESS_SKIP_COUNT` INT UNSIGNED,
    `ROLLBACK_COUNT`     INT UNSIGNED,
    `EXIT_CODE`          VARCHAR(2500),
    `EXIT_MESSAGE`       VARCHAR(2500),
    `LAST_UPDATED`       DATETIME,
    CONSTRAINT `JOB_EXEC_STEP_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `BATCH_JOB_EXECUTION` (`JOB_EXECUTION_ID`)
);

CREATE TABLE `BATCH_JOB_EXECUTION_CONTEXT`
(
    `JOB_EXECUTION_ID`   INT UNSIGNED  NOT NULL PRIMARY KEY,
    `SHORT_CONTEXT`      VARCHAR(2500) NOT NULL,
    `SERIALIZED_CONTEXT` text,
    CONSTRAINT `JOB_EXEC_CTX_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `BATCH_JOB_EXECUTION` (`JOB_EXECUTION_ID`)
);

CREATE TABLE `BATCH_STEP_EXECUTION_CONTEXT`
(
    `STEP_EXECUTION_ID`  INT UNSIGNED  NOT NULL PRIMARY KEY,
    `SHORT_CONTEXT`      VARCHAR(2500) NOT NULL,
    `SERIALIZED_CONTEXT` text,
    CONSTRAINT `STEP_EXEC_CTX_FK` FOREIGN KEY (`STEP_EXECUTION_ID`) REFERENCES `BATCH_STEP_EXECUTION` (`STEP_EXECUTION_ID`)
);
-- << Spring Batch

-- >> Version
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version`
(
    `version_target` VARCHAR(50)  NOT NULL,
    `version_number` INT UNSIGNED NOT NULL,
    `version_name`   VARCHAR(20)  NOT NULL,
    `update_status`  VARCHAR(10)  NOT NULL DEFAULT 'NONE',
    `created_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `creator`        VARCHAR(250),
    `updater`        VARCHAR(250),
    PRIMARY KEY (`version_target`, `version_number`),
    UNIQUE (`version_target`, `version_name`)
);
-- << Version
