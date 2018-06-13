package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.TblEmployeeMapper;
import com.example.demo.pojo.TblEmployee;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private TblEmployeeMapper tblEmployeeMapper;

	@Override
	public TblEmployee queryUserById(String userId) {
		tblEmployeeMapper.selectByPrimaryKey(userId);
		return null;
	}

	@Override
	public void saveEmployee(TblEmployee employee) {
		tblEmployeeMapper.insert(employee);
		
	}

	@Override
	public List<TblEmployee> getAll() {
		
		return tblEmployeeMapper.selectAll();
	}

	@Override
	public void insert(TblEmployee employee) {
		tblEmployeeMapper.insert(employee);
		
	}

	
	
	
	
}
