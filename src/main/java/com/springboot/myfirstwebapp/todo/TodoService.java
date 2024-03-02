package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "Bharani", "AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "BharaniJ28", "DevOps", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todosCount, "Bharani", "Spirng", LocalDate.now().plusYears(2), false));
	}

	public List<Todo> findByUserName(String username){
		return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	public Todo findById(int id) {
		Todo resultTodo = todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
		return resultTodo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
