package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_ALL_EMPS = "select empno,ename,job,sal,deptno from emp11 order by job";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> list = jt.query(GET_ALL_EMPS, rs -> {

			List<Employee> al = new ArrayList();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				// add model class object to list collection
				al.add(emp);
			}
			return al;

		});

		return list;
	}

	public static final String INSERT_EMP_QUERY = "Insert into emp11(empno,ename,job,sal,deptno)values(EMP_NO_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	public int insertEmployee(Employee emp) {
		int count = jt.update(INSERT_EMP_QUERY, emp.getEname(), emp.getJob(), emp.getSal(), emp.getDeptno());
		return count;
	}

	public static final String GET_EMP_BY_NO = "select empno,ename,job,sal,deptno from emp11 where empno=?";

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO, (rs, rowNum) -> {
			Employee e = new Employee();
			e.setEmpno(rs.getInt(1));
			e.setEname(rs.getString(2));
			e.setJob(rs.getString(3));
			e.setSal(rs.getFloat(4));
			e.setDeptno(rs.getInt(5));
			return e;
		}, no);
		return emp;
	}

	public static final String UPDATE_EMP_BY_NO = "update emp11 set ename=?,job=?,sal=?,deptno=? where empno=?";

	@Override
	public int updateEmployeeByNo(Employee emp) {
		int count = jt.update(UPDATE_EMP_BY_NO, emp.getEname(), emp.getJob(), emp.getSal(), emp.getDeptno(),
				emp.getEmpno());
		return count;
	}

	public static final String DELETE_EMP_BY_NO = "delete from emp11 where empno=?";
	@Override
	public int deleteEmployeeByNo(int no) {
		int count = jt.update(DELETE_EMP_BY_NO, no);
		return count;
	}

}
