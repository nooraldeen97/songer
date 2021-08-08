package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test public void testAlbumConstructor(){
		Album album = new Album("Italian Album","Dean Martin",6,8000,"https://m.media-amazon.com/images/I/41SJ7JWCCBL._SY580_.jpg");

	}
}
