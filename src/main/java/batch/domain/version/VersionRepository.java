package batch.domain.version;

import batch.domain.version.entity.Version;
import batch.domain.version.entity.VersionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository
        extends JpaRepository<Version, VersionPK> {}
