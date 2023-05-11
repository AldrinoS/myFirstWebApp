package com.example.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
