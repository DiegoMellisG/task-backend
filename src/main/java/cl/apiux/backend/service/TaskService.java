package cl.apiux.backend.service;

import cl.apiux.backend.dto.NewTaskDTO;
import cl.apiux.backend.dto.TaskDTO;
import cl.apiux.backend.mapper.TaskMapper;
import cl.apiux.backend.model.Task;
import cl.apiux.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/tasks")
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll(){
        try {
            List<Task> tasks = taskRepository.findAll();
            return ResponseEntity.ok(taskMapper.generateTaskDTOS(tasks));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
        try {
            Task task = taskRepository.findById(id).get();
            return ResponseEntity.ok(taskMapper.toTaskDTO(task));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody NewTaskDTO newtaskDTO) {
        try {
            Task task = taskMapper.fromNewTaskDTO(newtaskDTO);
            taskRepository.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        try {
            Task task = taskRepository.findById(id).get();
            task.setDescription(taskDTO.getDescription());
            task.setValidity(taskDTO.getValidity());
            taskRepository.save(task);
            return ResponseEntity.ok(taskMapper.toTaskDTO(task));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



}
