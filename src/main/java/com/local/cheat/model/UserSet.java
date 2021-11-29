package com.local.cheat.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserSet extends User{	
	private Integer cheats;
    private Timestamp createAt;
}
