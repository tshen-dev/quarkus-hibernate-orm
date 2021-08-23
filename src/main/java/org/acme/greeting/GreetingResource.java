package org.acme.greeting;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.gift.Gift;
import org.acme.gift.GiftService;

@Path("/gifts")
public class GreetingResource {

	@Inject GiftService giftService;
	private static final Random RANDOM = new Random();
	private static final List<String> GIFT = List.of("Remote control police car",
			"A talking cookie jar",
			"Pull-back vehicles",
			"A big bag of giant blocks",
			"Silly Skaters Unicorn",
			"An indoor bowling set",
			"A 3-D play carpet");
	private static final List<String> RECEIVER = List.of("Linh", 
			"Minh", 
			"Tai", 
			"Ky", 
			"Khanh", 
			"Hen", 
			"Trung");

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Gift gift() {
		String gift = GIFT.get(RANDOM.nextInt(GIFT.size()));
		String receiver = RECEIVER.get(RANDOM.nextInt(RECEIVER.size()));
		
		return giftService.createGift(gift, receiver);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Gift[] getAll() {
		return giftService.getAll();
	}
}
