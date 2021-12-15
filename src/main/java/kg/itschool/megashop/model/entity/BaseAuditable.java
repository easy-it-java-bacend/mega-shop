package kg.itschool.megashop.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseAuditable extends AbstractPersistable<Long> {

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    @Column(name = "last_modified_date", nullable = true)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date lastModifiedDate;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    Boolean isDeleted;

    @PrePersist
    private void onCreate() {
        isDeleted = false;
    }

    public Optional<LocalDateTime> getCreatedDate() {
        return null == this.createdDate ? Optional.empty() : Optional.of(LocalDateTime.ofInstant(this.createdDate.toInstant(), ZoneId.systemDefault()));
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = Date.from(createdDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Optional<LocalDateTime> getLastModifiedDate() {
        return null == this.lastModifiedDate ? Optional.empty() : Optional.of(LocalDateTime.ofInstant(this.lastModifiedDate.toInstant(), ZoneId.systemDefault()));
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = Date.from(lastModifiedDate.atZone(ZoneId.systemDefault()).toInstant());
    }

}
