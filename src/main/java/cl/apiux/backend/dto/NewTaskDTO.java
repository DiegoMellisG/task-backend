package cl.apiux.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewTaskDTO {

    private String description;
    private Boolean validity;
    private Boolean deleted;
}