package com.learn.spring.firstspringbootproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.spring.firstspringbootproject.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1, "jaypal", "Learn Springboot", new Date(),Boolean.FALSE));
		todos.add(new Todo(2, "jaypal", "Learn Agile", new Date(),Boolean.FALSE));
		todos.add(new Todo(3, "jaypal", "Big Data", new Date(),Boolean.FALSE));
	}
	
	public List<Todo> retriveTodos(String user){
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if(todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	public void addTodo(String user, String desc, Date targetDate,boolean isDone) {
		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
	}
	
	public void deleteDoto(int id) {
		Iterator<Todo> itr = todos.iterator();
		while(itr.hasNext()) {
			Todo todo = itr.next();
			if(todo.getId() == id) {
				itr.remove();
			}
		}
	}
	public Todo retriveTodo(int id){
		for (Todo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
}
