package org.vashonsd.pirateship;

import java.util.Stack;

import org.vashonsd.pirateship.structure.Location;
import org.vashonsd.pirateship.structure.World;

/*
 * Instances of PlayerState objects keep information about the current state of the Player.
 * The PlayerState object does not know anything about which player it was attached to.
 * 
 * Think of these roughly as being like commits in Git. They could, in theory, be explicitly saved
 * and we could return the player to an earlier state.
 */
public class PlayerState {
	
	private Location currentLocation;
	private World currentWorld;
	
	/*
	 * A Stack is a data type made for LIFO (last-in-first-out) operations. Think of it like a stack of books;
	 * you put a new book on top of the stack. When you take a book, you can easily take one off the top. That means
	 * the last book you put on the stack is the first one you take off.
	 * 
	 * In computer science, we would say you push(book) onto the stack, and you pop(book) off it. Same idea.
	 */
	private Stack<Process> processStack;
	
	/*
	 * This is some real premature optimization. This is just in case we want to keep prior states in a git-like
	 * tree. Such a scheme could be useful for levels of undo -- rolling back changes.
	 */
	private PlayerState priorState;
	
	public PlayerState(Process firstProcess) {
		super();
		processStack = new Stack<Process>();
		processStack.push(firstProcess);
	}
	
	public Process getCurrentProcess() {
		return processStack.peek();
	}
	
	public void quitCurrentProcess() {
		processStack.pop();
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void setCurrentLocation(Location curentLocation) {
		this.currentLocation = curentLocation;
	}
	
	public World getCurrentWorld() {
		return currentWorld;
	}
	public void setCurrentWorld(World currentWorld) {
		this.currentWorld = currentWorld;
	}
	
	
}
