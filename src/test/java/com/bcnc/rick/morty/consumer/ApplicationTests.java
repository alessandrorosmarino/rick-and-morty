package com.bcnc.rick.morty.consumer;

import com.bcnc.rick.morty.consumer.exception.NoRMCharacterFoundException;
import com.bcnc.rick.morty.consumer.web.controller.RMController;
import com.bcnc.rick.morty.consumer.web.entity.RMCharacterData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RMController rmController;

	/***
	 * This test case is to verify the controller is returning the correct number of characters
	 */
	@Test
	void test_controller_should_get_4_characters() {
		List<RMCharacterData> rmCharacterDataList = rmController.getRickAndMorty("Rick Sanchez");
		//printing the object to verify the content
		System.out.println(rmCharacterDataList);
		Assertions.assertEquals(4, rmCharacterDataList.size());
	}

	/***
	 * This test case is to verify the controller is throwing the correct exception when no character is found
	 */
	@Test
	void test_controller_gibberish_data_no_Character_found() {
		Assertions.assertThrows(NoRMCharacterFoundException.class,
				() -> rmController.getRickAndMorty("gibberishdata"));
	}

	/***
	 * This test case is to verify the controller is returning the correct number of characters when no name is provided
	 */
	@Test
	void test_controller_without_name_value() {
		List<RMCharacterData> rmCharacterDataList = rmController.getRickAndMorty("");
		//printing the object to verify the content
		System.out.println(rmCharacterDataList);
		Assertions.assertEquals(20, rmCharacterDataList.size());
	}

}
