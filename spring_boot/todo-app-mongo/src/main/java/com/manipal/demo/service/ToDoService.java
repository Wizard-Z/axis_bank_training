package com.manipal.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.bean.ToDo;
import com.manipal.demo.exception.ToDoNotFoundException;
import com.manipal.demo.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository toDoRepository;
	
	public ToDo addorUpdateToDo(ToDo toDo) {
		return toDoRepository.save(toDo);
		/*todos.add(toDo);
		return toDo;*/
	}
	
	public List<ToDo> getAllTodos(){
		return toDoRepository.findAll();
	}
	
	public ToDo getTodo(Integer id){
		return toDoRepository.findById(id).orElseThrow(()-> new ToDoNotFoundException("ToDo not found for the id: "+id));
	}
	
	public void deleteToDo(Integer id) {
		toDoRepository.deleteById(id);
	}
	public List<ToDo> findByuserName(String userName){
		return toDoRepository.findByUserName(userName);
	}
	
	public List<ToDo> getAllCompletedToDos(){
		return toDoRepository.getAllCompletedToDos();
	}
	
	
	
	
}
