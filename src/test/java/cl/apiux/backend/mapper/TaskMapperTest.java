package cl.apiux.backend.mapper;

import cl.apiux.backend.dto.NewTaskDTO;
import cl.apiux.backend.dto.TaskDTO;
import cl.apiux.backend.model.Task;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    @Test
    void toTaskDTO() {
        Task task = new Task();
        task.setValidity(true);
        task.setDescription("Testing Mapper to DTO");
        task.setDeleted(false);
        TaskMapper taskMapper = new TaskMapper();
        TaskDTO taskDTO = taskMapper.toTaskDTO(task);
        assertEquals(taskDTO.getDescription(), task.getDescription());
        assertEquals(taskDTO.getValidity(), task.getValidity());
        assertEquals(taskDTO.getDeleted(), task.getDeleted());
    }

    @Test
    void generateTaskDTOS() {
        Task task = new Task();
        task.setValidity(true);
        task.setDescription("Testing Mapper List to List DTO");
        task.setDeleted(false);
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(task);
        TaskMapper taskMapper = new TaskMapper();
        List<TaskDTO> tasksDTO = taskMapper.generateTaskDTOS(tasks);
        assertEquals(1, tasksDTO.size());
        assertEquals(tasks.get(0).getDescription(), tasksDTO.get(0).getDescription());
    }
}