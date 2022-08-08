package com.example.crudeoperationbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudeoperationbooksApplication implements CommandLineRunner
{
	@Autowired
	protected PasswordEncoder passwordEncoder;
	public static void main(String[] args)
	{
		SpringApplication.run(CrudeoperationbooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println(this.passwordEncoder.encode("xyz"));

	}
}
