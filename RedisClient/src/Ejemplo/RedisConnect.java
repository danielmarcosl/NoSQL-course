package Ejemplo;

import redis.clients.jedis.*;

public class RedisConnect {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("localhost");
		System.out.println("Conectados al servidor de Redis");
		System.out.println("Servidor ON: " + jedis.ping());
	}

}
