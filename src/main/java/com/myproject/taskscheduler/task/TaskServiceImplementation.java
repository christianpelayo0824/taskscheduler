package com.myproject.taskscheduler.task;

import com.myproject.taskscheduler.cache.CacheService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    private CacheService cacheService;

    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository,
                                     CacheService cacheService) {
        this.taskRepository = taskRepository;
        this.cacheService = cacheService;
    }


    /**
     * Service function that will call the {@link TaskRepository#findAll()}
     * for retrieving all the Task available.
     *
     * @return {@link List<TaskController>}
     * @author Christian Pelayo
     * @since 2020-05-04
     */
    @Cacheable("TaskServiceImplementation.findAll")
    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    /**
     * Service function that will call {@link TaskRepository#save(Object)}
     * to save {@link TaskController} object.
     *
     * @param taskPOJO the {@link TaskPOJO} object
     */
    @Override
    public boolean saveTask(TaskPOJO taskPOJO) {
        try {

            // Initialize Task Object.
            Task task = new Task();

            // User BeanUtils to Copy POJO object to the Entity.
            BeanUtils.copyProperties(taskPOJO, task);

            // Call repository function for saving a task object.
            taskRepository.save(task);

            // After saving a Task, Clear the cache
            cacheService.evictCachedByClassName(this.getClass());

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
