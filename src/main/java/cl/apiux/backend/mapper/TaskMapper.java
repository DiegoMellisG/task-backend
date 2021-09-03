package cl.apiux.backend.mapper;

import cl.apiux.backend.dto.NewTaskDTO;
import cl.apiux.backend.dto.TaskDTO;
import cl.apiux.backend.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskDTO toTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription(task.getDescription());
        taskDTO.setValidity(task.getValidity());
        taskDTO.setDeleted(task.getDeleted());
        taskDTO.setCreateDateTime(task.getCreatedDateTime());
        taskDTO.setUpdateDateTime(task.getUpdatedDateTime());
        return taskDTO;
    }

    public Task fromNewTaskDTO(NewTaskDTO newTaskDTO){
        Task task = new Task();
        task.setDescription(newTaskDTO.getDescription());
        task.setValidity(newTaskDTO.getValidity());
        task.setDeleted(newTaskDTO.getDeleted());
        return task;
    }

    public List<TaskDTO> generateTaskDTOS(List<Task> tasks)
    {
        return tasks.stream().map(this::toTaskDTO).collect(Collectors.toList());
    }
}
