package org.acme.gift;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class GiftService {

	private @Inject EntityManager entityManager;

	@Transactional
	public Gift createGift(String giftDescription, String receiver) {
		Gift gift = new Gift(giftDescription, receiver);
		entityManager.persist(gift);
		return gift;
	}

	public Gift[] getAll() {
		return entityManager.createNamedQuery("Gift.findAll", Gift.class)
				.getResultList()
				.toArray(new Gift[0]);
	}
}
