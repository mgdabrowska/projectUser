package com.testowy.projectUser.todo;



import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
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

    @GetMapping("/addTodos")
    public String showNewTodosPage(Model model){
        String username =(String) model.asMap().get("name");
        Todo todo = new Todo(0,username,"", LocalDate.now().plusYears(1),false);
        model.addAttribute("todo", todo);
        return "addTodos";
    }

    @PostMapping("/addTodos")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult result){

       if(result.hasErrors()){
            return "addTodos";
        }

        String username =(String) model.asMap().get("name");
        todoService.addTodo(username,
                todo.getDescription(),
                todo.getTargetDate(),
                false);
        return "redirect:/listTodos";
    }

    @RequestMapping("/delete-Todo")
    public String deleteTodo(@RequestParam int id){
        todoService.removeTodoById(id);
        return "redirect:/listTodos";
    }

    @GetMapping("/update-Todo")
    public String showUpdateTodo(@RequestParam int id, Model model){
        Todo todo= todoService.findById(id);
      model.addAttribute("todo", todo);
        return "addTodos";
    }

    @PostMapping("/update-Todo")
    public String updateTodo( Model model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "addTodos";
        }
        String username =(String) model.asMap().get("name");
       todo.setUsername(username);
       todoService.updateTodo(todo);
        return "redirect:/listTodos";

    }
}
