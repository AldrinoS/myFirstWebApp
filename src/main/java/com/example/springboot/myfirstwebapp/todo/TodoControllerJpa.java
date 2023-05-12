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
public class TodoControllerJpa {

    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {

        List<Todo> byUserName = todoRepository.findByUsername(getLoggedinUsername(model));
        model.addAttribute("todos", byUserName);
        return "listTodos";
    }

    private static String getLoggedinUsername(ModelMap model) {
        return (String) model.get("name");
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model) {
        Todo todo = new Todo(0, getLoggedinUsername(model), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggedinUsername(model));
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

        Todo todo = todoRepository.findById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        todo.setUsername(getLoggedinUsername(model));
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}
