package cl.apiux.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TaskDTO {
    // Only business data
    private String description;
    private Boolean validity;
    private Boolean deleted;
    private ZonedDateTime createDateTime;
    private ZonedDateTime updateDateTime;
}
