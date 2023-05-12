package com.example.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "name", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "name", "Learn GCP", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUserName(String name) {
        return todos.stream().filter(todo -> name.equalsIgnoreCase(todo.getUsername())).collect(Collectors.toList());
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId()==id);
    }

    public Todo findById(int id) {
        return todos.stream().filter(todo -> todo.getId()==id).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}
