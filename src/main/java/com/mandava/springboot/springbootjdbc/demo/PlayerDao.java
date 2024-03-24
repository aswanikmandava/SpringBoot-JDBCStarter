package com.mandava.springboot.springbootjdbc.demo;

import java.sql.Timestamp;
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
	
	public Player getPlayerById(int id) {
		String sql = "SELECT * FROM Player where ID = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Player>(Player.class), new Object[] {id});
	}
	
	public int insertPlayer(Player player) {
		String sql = "INSERT INTO Player(ID, Name, Nationality, Birth_date, Titles) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, new Object[] {player.getId(), player.getName(), player.getNationality(),
				new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
	}
	
	public int updatePlayer(Player player) {
		String sql = "UPDATE Player SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ? " +
					"WHERE ID = ?";
		return jdbcTemplate.update(sql, new Object[] {player.getName(), player.getNationality(),
				new Timestamp(player.getBirthDate().getTime()), player.getTitles(), player.getId()});
		
	}
	
	public int deletePlayerById(int id){
	    String sql="DELETE FROM PLAYER WHERE ID = ?";
	    return jdbcTemplate.update(sql, new Object[] {id});
	}
}
