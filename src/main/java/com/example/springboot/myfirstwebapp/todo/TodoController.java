package com.example.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String showNewTodoPage(ModelMap model) {
        Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        todoService.addTodo(String.valueOf(model.get("name")), todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }
}
