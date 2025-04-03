package com.testowy.projectUser.todo;



import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

    private TodoService todoService;
    private TodoRepository todoRepository;


    public TodoControllerJPA(TodoRepository todoRepository, TodoService todoService) {
        super();
        this.todoRepository = todoRepository;
        this.todoService=todoService;
    }



    @GetMapping("/listTodos")
    public String listAllTodos(Model model){
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername(username);

        model.addAttribute("todos",todos);
        return "listTodos";
    }


    @GetMapping("/addTodos")
    public String showNewTodosPage(Model model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username,"", LocalDate.now().plusYears(1),false);
        model.addAttribute("todo", todo);
        return "addTodos";
    }

    @PostMapping("/addTodos")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult result){

       if(result.hasErrors()){
            return "addTodos";
        }

        String username = getLoggedInUsername(model);
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
        Optional<Todo> todo= todoService.findById(id);
      model.addAttribute("todo", todo);
        return "addTodos";
    }

    @PostMapping("/update-Todo")
    public String updateTodo( Model model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "addTodos";
        }
        String username = getLoggedInUsername(model);
       todo.setUsername(username);
       todoService.updateTodo(todo);
        return "redirect:/listTodos";

    }
    private String getLoggedInUsername(Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
