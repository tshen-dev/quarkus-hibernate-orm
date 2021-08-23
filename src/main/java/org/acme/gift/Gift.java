package org.acme.gift;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

@Entity
@NamedQuery(name = "Gift.findAll",
      query = "SELECT g FROM Gift g ORDER BY g.id",
      hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Gift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String receiver;

	public Gift() {}
	
	public Gift(String name, String receiver) {
		this.name = name;
		this.receiver = receiver;
	}
	
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}