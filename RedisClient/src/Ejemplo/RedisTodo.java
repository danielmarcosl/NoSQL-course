package Ejemplo;

import redis.clients.jedis.Jedis;

public class RedisTodo {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		String cacheKey = "Lenguajes";

		jedis.sadd(cacheKey, "Java", "Python", "Node.js", "C#");
		System.out.println("Lenguajes de programación: " + jedis.smembers(cacheKey));

		System.out.println("\n");

		jedis.sadd(cacheKey, "Ruby", ".NET");
		System.out.println("Lenguajes de programación: " + jedis.smembers(cacheKey));

	}
}
