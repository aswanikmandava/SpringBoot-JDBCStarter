package com.mandava.springboot.springbootjdbc.demo;


import org.slf4j.LoggerFactory;

import java.sql.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// logger.info("Getting player by id(3): {}", dao.getPlayerById(3));
		// logger.info("Inserting a new player(4): {}", dao.insertPlayer(new Player(4, "Nadal", "Serbia", new Date(System.currentTimeMillis()), 10)));
		// logger.info("Updating player with id 4: ", dao.updatePlayer(new Player(4, "Nadal", "Russia", Date.valueOf("2000-01-15"), 15)));
		logger.info("Deleting player with id 4:", dao.deletePlayerById(4));
		logger.info("All Players Data: {}", dao.getAllPlayers());
	}

}
