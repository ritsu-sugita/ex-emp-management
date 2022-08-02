package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository

public class EmployeeRepositry {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getTimestamp("hireDate"));
		employee.setMailAdress(rs.getString("mailaddress"));
		employee.setZipCode(rs.getString("zipCode"));
		employee.setAddress(rs.getString("address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependsmentsCount"));

		return employee;
	};

	public List<Employee> findAll() {
		String sql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address"
				+ ",telephone,salary,characteristics,dependents_count FROM employees ORDER BY hire_date";
		List<Employee> employeeLIst = template.query(sql, EMPLOYEE_ROW_MAPPER);

		return employeeLIst;
	}

	public Employee load(Integer id) {

		String sql = "SELECT id,name,image,gender,hire_date,mail_address,zip_code,address"
				+ ",telephone,salary,characteristics,dependents_count FROM employees WHERE id=:id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

	}

	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);

		String sql = "UPDATE employees SET name=:name,image=:image,gender=:gender,hire_date=:hire_date,"
				+ "mail_address=:mail_address,zip_code=:zip_code,address=:address,telephone=:telephone,"
				+ "salary=:salary,characteristics=:characteristics,dependents_count=:dependents_count"
				+ " WHERE id=:id";
		template.update(sql, param);
	};
}
