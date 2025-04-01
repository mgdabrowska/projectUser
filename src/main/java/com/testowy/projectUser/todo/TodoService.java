package com.testowy.projectUser.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

     static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount, "Coursera", "Learn Java",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "Coursera", "Learn AWS",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todoCount, "Coursera", "Learn FullStack Development",
                LocalDate.now().plusYears(3), false));

    }

    public void addTodo(String username, String description, LocalDate targetDay, boolean done){
        Todo todo = new Todo(++todoCount,username,description,targetDay, done);
        todos.add(todo);
    }

    public void removeTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        System.out.println(todos);
        todos.removeIf(predicate);
        System.out.println(todos);
    }
    public List<Todo> findUsername(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername() !=null && username.equalsIgnoreCase((todo.getUsername()))).toList();

    }
    public Optional<Todo> findById(int id) {

        return todos.stream()
                .filter(todo -> todo.getId() == id).findFirst();

    }

    public void updateTodo(@Valid Todo todo) {
        removeTodoById(todo.getId());
        todos.add(todo);

    }
}
