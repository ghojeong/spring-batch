package batch.domain.version.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class VersionPK implements Serializable {
    private VersionTarget target;
    private Integer versionNumber;
}
