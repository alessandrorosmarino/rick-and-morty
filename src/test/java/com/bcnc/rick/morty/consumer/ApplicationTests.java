package com.bcnc.rick.morty.consumer;

import com.bcnc.rick.morty.consumer.web.entity.RMCharacterData;
import com.bcnc.rick.morty.consumer.web.service.RMConsumerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RMConsumerService rmConsumerService;

	@Test
	void test_consumer_service_should_get_4_characters() {
		List<RMCharacterData> rmCharacterDataList = rmConsumerService.getCharacterForConsumerByName("Rick Sanchez");
		System.out.println(rmCharacterDataList);
		Assertions.assertEquals(4, rmCharacterDataList.size());
	}

}
