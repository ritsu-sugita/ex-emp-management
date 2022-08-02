package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.Param;

import jp.co.sample.domain.Administrator;

@Repository

public class AdministoratorRepsitory {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailaddress"));
		administrator.setPassword(rs.getString("password"));

		return administrator;
	};

	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);

		String inesrtsql = "INSERT INTO administrators (id,name,mailaddress,password)VALUES(:id,:name,:mailaddress,:password)";
		template.update(inesrtsql, param);
	}

	public Administrator findByMailaddressAndPassword(String mailAddress, String password) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress)
				.addValue("password",password);
		String sql = "SELECT id,name,mailaddress,password FROM admisistrators where mailaddress=:mailaddress and password=:password";
		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		if (administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}
}
