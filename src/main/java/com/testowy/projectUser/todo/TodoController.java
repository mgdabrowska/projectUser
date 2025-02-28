package com.testowy.projectUser.todo;



import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
        String username =(String) model.getAttribute("name");
        Todo todo = new Todo(0,username,"", LocalDate.now().plusYears(1),false);
        model.addAttribute("todo", todo);
        return "addTodos";
    }

    @PostMapping("/addTodos")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "addTodos";
        }

        String username =(String) model.getAttribute("name");
        todoService.addTodo(username,
                todo.getDescription(),
                LocalDate.now().plusYears(1),
                false);
        return "redirect:/listTodos";
    }

    @GetMapping("/delete-Todo")
    public String deleteTodo(@RequestParam int id){
        todoService.removeTodoById(id);
        return "redirect:/listTodos";
    }

    @GetMapping("/update-Todo")
    public String updateTodo(@RequestParam int id, Model model){
        Todo todo= todoService.findById(id);
      model.addAttribute("todo", todo);
        return "addTodos";
    }
}
