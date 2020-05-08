package com.myproject.taskscheduler.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * REST-End Point for Task Object.
 *
 * @author christian
 * @since 2020-05-08
 */
@RestController
@RequestMapping(path = "/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * REST-End Point use for retrieving all {@link Task} objects. <br>
     * Usage URL:
     * <blockquote>
     * <pre>
     *      "http://domain/task/findAll"
     * </pre>
     * </blockquote>
     *
     * @return ResponseEntity
     */
    @GetMapping(path = "/findAll")
    public ResponseEntity<List<Task>> findAllTask() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    /**
     * REST-End Point use for saving {@link Task} object. <br>
     * Usage URL:
     * <blockquote>
     * <pre>
     *      "http://domain/task/save"
     * </pre>
     * </blockquote>
     *
     * @param taskPOJO The {@link TaskPOJO} object to be save.
     * @return The Response in a Map form.
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> saveTask(@RequestBody TaskPOJO taskPOJO) {

        // Response Holder
        Map<String, Object> returnMap = new HashMap<>();

        // Check if the saving is success
        boolean isSave = taskService.saveTask(taskPOJO);

        // Construct response message.
        String message = isSave ? "Successfully Inserted" : "Failed Inserting";

        // Add the message to the map.
        returnMap.put("message", message);

        // Return
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }

}
