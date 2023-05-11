package com.example.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "in28Min", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "in28Min", "Learn GCP", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUserName(String name) {
        return todos;
    }
}
