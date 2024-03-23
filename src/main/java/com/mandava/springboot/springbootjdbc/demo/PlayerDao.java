package com.mandava.springboot.springbootjdbc.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Player> getAllPlayers(){
		String sql = "SELECT * FROM Player";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
	}
}
