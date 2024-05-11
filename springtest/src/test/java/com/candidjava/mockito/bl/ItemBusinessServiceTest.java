package com.candidjava.mockito.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//package com.candidjava.mockito.spike;
import com.candidjava.mockito.data.ItemRepository;
import com.candidjava.mockito.model.Item;

@ExtendWith(MockitoExtension.class)   // wiremock
public class ItemBusinessServiceTest {

	@InjectMocks  // autowire
	private ItemBusinessService business;

	@Mock  //@Spy
	private ItemRepository repository;

	//MockBean -->MVC, 
	
	@Test
	public void retrieveAllItems_basic() 
	{
		
		when(repository.findAll())
			.thenReturn(
					Arrays.asList(new Item(2,"Item2",10,11),
								  new Item(3,"Item3",20,20))
					);
		
		List<Item> items = business.retrieveAllItems();
		
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}
}
