package com.learn.spring.firstspringbootproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learn.spring.firstspringbootproject.model.Todo;
import com.learn.spring.firstspringbootproject.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listTodos(ModelMap modelMap) {
		String name = getLoggedInUserName(); 
		System.out.println(name);
		modelMap.put("todos", todoService.retriveTodos(name));
		return "list-todos";
	}

	public String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication()
		.getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap modelMap) {
		modelMap.addAttribute("todo", new Todo(0, getLoggedInUserName(), "Default Desc", new Date(), Boolean.FALSE));
		return "add-todo";
	}
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodo(ModelMap modelMap,@Valid Todo todo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "add-todo";
		}
		todoService.addTodo(getLoggedInUserName(), todo.getDesc(), todo.getTargetDate(), Boolean.TRUE);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		if(id ==1) {
			throw new RuntimeException("error Occurred");
		}
		todoService.deleteDoto(id);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap modelMap) {
		Todo todo = todoService.retriveTodo(id);
		modelMap.put("todo", todo);
		return "add-todo";
	}
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap modelMap,@Valid Todo todo, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "add-todo";
		}
		todo.setUser(getLoggedInUserName());
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
}
