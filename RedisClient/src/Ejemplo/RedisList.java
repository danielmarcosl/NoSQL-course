package Ejemplo;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisList {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");

		jedis.lpush("EjemploList", "Redis");
		jedis.lpush("EjemploList", "MongoDB");
		jedis.lpush("EjemploList", "Cassandra");
		jedis.lpush("EjemploList", "CouchDB");
		jedis.lpush("EjemploList", "Patata");
		
		List<String> list = jedis.lrange("EjemploList", 0, 4);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
