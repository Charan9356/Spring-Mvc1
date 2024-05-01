package spring_mvc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc2.dao.EmployeeDao;
import spring_mvc2.dto.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeedao;
	
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		ModelAndView view = new ModelAndView();
		try {
			employeedao.saveEmployee(employee);
			view.setViewName("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			view.setViewName("register.jsp");
		}
		return view;
	}
	@RequestMapping("/login")
	public ModelAndView loginEmployee(@RequestParam String email,@RequestParam String pwd) {
		ModelAndView view = new ModelAndView();
		try {
			Employee db = employeedao.fetchByEmail(email);
			List<Employee> list = employeedao.fetchAll();
			if(db.getPwd().equals(pwd)) {
				view.addObject("list", list);
				view.setViewName("home.jsp");
			}
			else {
				view.addObject("msg", "password is wrong");
				view.setViewName("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			view.addObject("msg", "email is wrong");
			view.setViewName("login.jsp");
		}
		return view;
	}
	@RequestMapping("/update")
	public ModelAndView updateEmployee(@RequestParam int id) {
			ModelAndView view = new ModelAndView();
			Employee db = employeedao.fetchByid(id);
			if(db!=null) {
				view.addObject("db", db);
				view.setViewName("edit.jsp");
			}
			return view;
	}
	@RequestMapping("/edit")
	public ModelAndView editEmployee(@ModelAttribute Employee employee) {
			ModelAndView view = new ModelAndView();
			Employee db = employeedao.update(employee);
			if(db!=null) {
				List<Employee> list = employeedao.fetchAll();
				view.addObject("list", list);
				view.setViewName("home.jsp");
			}
			return view;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		ModelAndView view = new ModelAndView();
		Employee db = employeedao.delete(id);
		if(db!=null) {
			List<Employee> list = employeedao.fetchAll();
			view.addObject("list", list);
			view.setViewName("home.jsp");
		}
		return view;
	}
}
