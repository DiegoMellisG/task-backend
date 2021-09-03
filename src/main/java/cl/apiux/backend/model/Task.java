package cl.apiux.backend.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name="task")
@Data
@SQLDelete(sql = "UPDATE task SET deleted=true WHERE id = ?")
public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    private Long id;

    //Description
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    // Validity
    // Assume validity is not done yet -> validity = true
    @Column(name = "validity", nullable = false)
    private Boolean validity;

    //To not delete de register, use this column
    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean deleted;

    // Create time
    @CreationTimestamp
    @Column(name = "created_date_time", nullable = false, updatable = false)
    private ZonedDateTime createdDateTime;

    // Last update
    @UpdateTimestamp
    @Column(name = "updated_date_time", nullable = false, updatable = false)
    private ZonedDateTime updatedDateTime;
}
