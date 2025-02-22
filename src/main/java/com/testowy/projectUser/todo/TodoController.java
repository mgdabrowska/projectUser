package com.testowy.projectUser.todo;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }



    @GetMapping("/listTodos")
    public String listAllTodos(Model model){
        List<Todo> todos = todoService.findUsername("Coursera");
        model.addAttribute("todos",todos);
        return "listTodos";
    }
}
