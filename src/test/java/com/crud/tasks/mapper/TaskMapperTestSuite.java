package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Zadanie 29.2 increase test coverage
@SpringBootTest
public class TaskMapperTestSuite {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1111L, "testTask", "test content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1111L, (long)task.getId());
        assertEquals("testTask", task.getTitle());
        assertEquals("test content", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1111L, "testTask", "test content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1111L, (long)taskDto.getId());
        assertEquals("testTask", taskDto.getTitle());
        assertEquals("test content", taskDto.getContent());
    }

    @Test
    public void testMapToListDto() {
        //Given
        Task task = new Task(1111L, "testTask", "test content");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //When
        List<TaskDto> tasksDto = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(1, tasksDto.size());
    }
}