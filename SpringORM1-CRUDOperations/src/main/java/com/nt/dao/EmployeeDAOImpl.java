package com.nt.dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private HibernateTemplate template;

	public int insert(Employee emp) {
		// specify this operation as non-select operation

		template.setCheckWriteOperations(false);

		// save object
		int idVal = (Integer) template.save(emp);
		return idVal;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// get the object by id
		Employee emp = template.get(Employee.class, id);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		// update the employee object

		Employee emp1 = getEmployeeById(emp.getEmpno());
		if (emp1 == null) {
			return "Employee not found  ";
		} else {

			// update the object
			BeanUtils.copyProperties(emp, emp1);
			template.update(emp1);
			return emp1.getEmpno() + " Employee is updated ";
		}

	}

	@Override
	public String deleteEmployeeById(int id) {
		Employee emp = getEmployeeById(id);
		if (emp == null) {
			return "Employee not found  ";
		} else {
			template.delete(emp);
			return emp.getEmpno() + " Employee deleted";
		}

	}

	@Override
	public List<?> getAllEmployees() {
		List<?> list = template.find("from Employee", null);
		return list;
	}

}
