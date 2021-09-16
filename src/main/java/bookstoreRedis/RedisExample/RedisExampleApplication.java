package bookstoreRedis.RedisExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


import bookstoreRedis.RedisExample.mode.Book;

@SpringBootApplication
public class RedisExampleApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(RedisExampleApplication.class, args);
	}

}
