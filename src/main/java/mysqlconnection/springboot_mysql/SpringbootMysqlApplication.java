package mysqlconnection.springboot_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public record SpringbootMysqlApplication(@Autowired JdbcTemplate jdbcTemplate) implements CommandLineRunner {

	public SpringbootMysqlApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringbootMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String sql = "INSERT INTO city (Name,CountryCode,District,Population) VALUES(?,?,?,?)";
		int result = jdbcTemplate.update(sql,"chamandeswari", "91+", "Guntur", "548564");
		if (result > 0) {
			System.out.println("A new row has been inserted...");
		}

	}
}
