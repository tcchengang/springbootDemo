package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.TblEmployee;
import com.example.demo.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TestController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("test")
	public String test() {
		return "Hello";
	}
	
	
	@RequestMapping("/test3")
	public Object test3() {
		return employeeService.queryUserById("13");
	}
	@RequestMapping("/save")
	public String save() {
		TblEmployee tblEmployee=new TblEmployee();
		tblEmployee.setGender("springboot");
		tblEmployee.setEmail("springn");
		tblEmployee.setLastname("boot");
		employeeService.saveEmployee(tblEmployee);
		return "ok";
	}
	@RequestMapping("/getemps")
	public String getAllEmps(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum ,Model model){
		PageHelper.startPage(pageNum, 5);
		List<TblEmployee> emps=employeeService.getAll();
		PageInfo info=new PageInfo(emps,5);
		//PageInfo<TblEmployee> info=new page
		//info.getPrePage()
		int[] num=info.getNavigatepageNums();
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		//System.out.println(info.getNavigatepageNums());
		model.addAttribute("pageInfo", info);
		return "freemaker/test";
	}
	
	@RequestMapping("/testTransication")
	@Transactional(propagation=Propagation.REQUIRED)
	public void testTransication() {
		TblEmployee tblEmployee=new TblEmployee();
		tblEmployee.setGender("springboot1");
		tblEmployee.setEmail("springn");
		tblEmployee.setLastname("boot");
		employeeService.insert(tblEmployee);
		System.out.println("------一条");
		int i=1/0;
		TblEmployee tblEmployee2=new TblEmployee();
		tblEmployee2.setGender("springboot2");
		tblEmployee2.setEmail("springn");
		tblEmployee2.setLastname("boot");
		employeeService.insert(tblEmployee2);
	}
	@RequestMapping("/testlogin")
	public String testLogin() {
		return "freemaker/index";
	}
}
