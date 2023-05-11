package com.example.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> byUserName = todoService.findByUserName("");
        model.addAttribute("todos", byUserName);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage() {
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(@RequestParam String description, ModelMap model) {
        todoService.addTodo(String.valueOf(model.get("name")), description, LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
