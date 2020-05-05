package com.myproject.taskscheduler.service.task;

import com.myproject.taskscheduler.controller.TaskController;
import com.myproject.taskscheduler.model.Task;
import com.myproject.taskscheduler.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class that handle the business logic of <br>
 * Task Object.
 *
 * @author Christian Pelayo
 * @since 2020-05-03
 */
@Service
public class TaskServiceImplementation implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    /**
     * Service function that will call the {@link TaskRepository#findAll()}
     * for retrieving all the Task available.
     *
     * @return {@link List< TaskController >}
     * @author Christian Pelayo
     * @since 2020-05-04
     */
    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    /**
     * Service function that will call {@link TaskRepository#save(Object)}
     * to save {@link TaskController} object.
     *
     * @param task the {@link TaskController} object
     */
    @Override
    public boolean saveTask(Task task) {
        try {
            taskRepository.save(task);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Service function that will call {@link TaskRepository#saveAll(Iterable)}
     * to save list of {@link TaskController} objects.
     *
     * @param tasks list of {@link TaskController} object
     * @author Christian Pelayo. 03 Apr 2020
     */
    @Override
    public void saveAllTask(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }
}
