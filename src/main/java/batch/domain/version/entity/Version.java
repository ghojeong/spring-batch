package batch.domain.version.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "version")
@IdClass(VersionPK.class)
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Version {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "version_target", updatable = false)
    private VersionTarget target;

    @Id
    @Column(name = "version_number")
    private Integer versionNumber;

    @Column(name = "version_name")
    private String versionName;

    @Enumerated(EnumType.STRING)
    @Column(name = "update_status")
    private VersionUpdateStatus updateStatus;

    @CreatedDate
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
    @CreatedBy
    @Column(name = "creator", updatable = false)
    private String creator;
    @LastModifiedBy
    @Column(name = "updater")
    private String updater;


    @Override
    public String toString() {
        return "Version{" +
                "\ntarget=" + target.name() +
                ",\nversionNumber=" + versionNumber +
                ",\nversionName='" + versionName +
                ",\nupdateStatus=" + updateStatus +
                ",\ncreatedAt=" + createdAt +
                ",\nupdatedAt=" + updatedAt +
                ",\ncreator='" + creator +
                ",\nupdater='" + updater +
                '}';
    }
}
