package com.gmission.doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
/*
ComponentScan({
	"com.gmission.doc.controller",
	"com.gmission.doc.service",
	"com.gmission.doc.mapper",
	"com.gmission.doc.springsecurity",
	"com.gmission.doc.springsecurity.service",
	"com.gmission.doc.springsecurity.service.SecurityLoginService",
	"com.gmission.doc.springsecurity.service.SecurityLoginMapper"
})
*/

public class GmSAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmSAdminApplication.class, args);
	}

}
