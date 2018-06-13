package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.TblEmployee;



public interface EmployeeService {
	public TblEmployee queryUserById(String userId);
	public void saveEmployee(TblEmployee employee);
	public List<TblEmployee> getAll();
	public void insert(TblEmployee employee);
}
