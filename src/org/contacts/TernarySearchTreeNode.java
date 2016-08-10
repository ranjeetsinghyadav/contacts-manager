package org.contacts;

/**
 * This object represents a node of Ternary Search Tree
 * 
 * @author ranjeet singh yadav
 */
public class TernarySearchTreeNode {

	/**
	 * Character stored in the node
	 */
	char data;

	/**
	 * Marker to identify the end of a string stored in TST
	 */
	boolean isEndOfString;
	
	/**
	 * Child nodes of TST
	 */
	TernarySearchTreeNode left, middle, right;

	public TernarySearchTreeNode(char data) {
		this.data = data;
		this.isEndOfString = false;
		this.left = null;
		this.middle = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "data=" + data + ", isEndOfString=" + isEndOfString;
	}
}
