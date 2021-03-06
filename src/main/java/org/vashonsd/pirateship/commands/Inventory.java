package org.vashonsd.pirateship.commands;

import org.vashonsd.pirateship.interactions.Actor;
import org.vashonsd.pirateship.interactions.Player;
import org.vashonsd.pirateship.interactions.Response;

public class Inventory extends Command {
	
	public Inventory() {
		super();
		addKeyword("inventory");
	}
	
	@Override
	public Response execute(Actor obj, Player from) {
		 return new Response(from.getInventory().toString());
	}
	
	
}
