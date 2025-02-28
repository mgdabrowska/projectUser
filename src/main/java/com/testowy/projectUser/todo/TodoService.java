package com.testowy.projectUser.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        todos.removeIf(predicate);
    }
    public List<Todo> findUsername(String username) {

        return todos;
    }
    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
}
