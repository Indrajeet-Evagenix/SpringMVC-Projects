package com.becoder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.becoder.dao.EmpDao;
import com.becoder.dao.UserDao;
import com.becoder.entity.Emp;
import com.becoder.entity.User;

@Controller
public class HomeController {

	@Autowired
	private EmpDao empDao;

	@Autowired
	private UserDao userDao;

	@RequestMapping(path = "/home")
	public String home(Model m) {

		List<Emp> list = empDao.getAllEmp();
		m.addAttribute("empList", list);

		return "home";
	}

	@RequestMapping(path = "/addEmp")
	public String addEmp() {
		return "add_emp";
	}

	@RequestMapping(path = "/createEmp", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute Emp emp, HttpSession session) {

//		System.out.println(emp);
		int i = empDao.saveEmp(emp);
		session.setAttribute("msg", "Registered Successfully");
		System.out.println(i + " Record Inserted Successfully");

		return "redirect:/addEmp";
	}

	@RequestMapping(path = "/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m) {

		Emp emp = empDao.getEmp(id);
		m.addAttribute("emp", emp);

		return "edit_emp";
	}

	@RequestMapping(path = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute Emp emp, HttpSession session) {

		empDao.update(emp);
		session.setAttribute("msg", "Update Successfully");

		return "redirect:/home";
	}

	@RequestMapping(path = "/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {

		empDao.deleteEmp(id);
		session.setAttribute("msg", "Deleted Successfully");

		return "redirect:/home";
	}

	@RequestMapping(path = "/register")
	public String registerPage() {

		return "register";
	}

	@RequestMapping(path = "/login")
	public String loginPage() {

		return "login";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, HttpSession session) {

//		System.out.println(user);

		userDao.saveUser(user);
		session.setAttribute("msg", "User Registered Successfully");

		return "redirect:/register";
	}

	@RequestMapping(path = "/userlogin", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		User user = userDao.loginUser(email, password);
		if (user != null) {
			session.setAttribute("loginUser", user);
			return "profile";
		} else {
			session.setAttribute("msg", "Invalid Credentials");
		}

		return "redirect:/login";
	}

	@RequestMapping(path = "/myProfile")
	public String myProfile() {

		return "profile";
	}

	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request, HttpSession session) {

		session = request.getSession();
		session.removeAttribute("loginUser");
		session.setAttribute("msg", "Logout Successfully");

		return "login";
	}

}
