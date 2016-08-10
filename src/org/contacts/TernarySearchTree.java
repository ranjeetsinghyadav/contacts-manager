package org.contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * This object holds the data structure and operations to manage(add/search)
 * strings efficiently
 * 
 * @author ranjeet singh yadav
 */
public class TernarySearchTree {

	/**
	 * Root node of Ternary Search Tree
	 */
	private TernarySearchTreeNode root;

	/** Constructor **/
	public TernarySearchTree() {
		root = null;
	}

	/**
	 * Method to add a string in TST
	 * 
	 * @param word
	 */
	public void add(String word) {
		if (word != null && word.length() > 0) {
			root = add(root, word.toCharArray(), 0);
		}
	}

	/**
	 * Private recursive method to add a string, used by public add method
	 * 
	 * @param node
	 *            TST node
	 * @param word
	 *            Character array of the string to be added
	 * @param pointer
	 *            current pointer of the word array
	 * @return
	 */
	private TernarySearchTreeNode add(TernarySearchTreeNode node, char[] word, int pointer) {
		if (node == null) {
			node = new TernarySearchTreeNode(word[pointer]);
		}
		if (word[pointer] < node.data) {
			node.left = add(node.left, word, pointer);
		} else if (word[pointer] > node.data) {
			node.right = add(node.right, word, pointer);
		} else {
			if (pointer + 1 < word.length) {
				node.middle = add(node.middle, word, pointer + 1);
			} else {
				node.isEndOfString = true;
			}
		}
		return node;
	}

	/**
	 * Method to search all matching strings which are having input word as
	 * prefix to them
	 * 
	 * @param word
	 *            string to be searched
	 * @return list of matching strings
	 */
	public List<String> search(String word) {
		if (word != null && word.length() > 0) {
			return search(new ArrayList<String>(), root, word.toCharArray(), 0);
		} else {
			return null;
		}
	}

	/**
	 * Private recursive method to search all matching strings which are having
	 * input word as prefix to them
	 * 
	 * @param list
	 *            list of matching strings
	 * @param node
	 *            current recursive node
	 * @param word
	 *            string to be searched in char array form
	 * @param pointer
	 *            current position in char array
	 * @return List of matching strings
	 */
	private List<String> search(List<String> list, TernarySearchTreeNode node, char[] word, int pointer) {
		if (node == null) {
			return list;
		}
		if (word[pointer] < node.data) {
			return search(list, node.left, word, pointer);
		} else if (word[pointer] > node.data) {
			return search(list, node.right, word, pointer);
		} else {
			if (pointer == word.length - 1) {
				String str = String.valueOf(word);
				list.addAll(traverse(node, str.substring(0, str.length() - 1)));
				return list;
			} else {
				return search(list, node.middle, word, pointer + 1);
			}
		}
	}

	/**
	 * Method to traverse all the child nodes of the input node of TST and
	 * builds the list of strings
	 * 
	 * @param node
	 *            input node
	 * @param str
	 *            prefix string for current node
	 * @return List of all string formed by child nodes of input node
	 */
	public List<String> traverse(TernarySearchTreeNode node, String str) {
		return traverse(node, new ArrayList<String>(), str);
	}

	/**
	 * Private method to traverses recursively all the child nodes of the input
	 * node of TST and builds the list of strings
	 * 
	 * @param node
	 *            current input node
	 * @param strList
	 *            List of matching strings
	 * @param str
	 *            prefix string for current node
	 * @return List of all string formed by child nodes
	 */
	private List<String> traverse(TernarySearchTreeNode node, List<String> strList, String str) {
		if (node != null) {
			traverse(node.left, strList, str);
			str = str + node.data;
			if (node.isEndOfString) {
				strList.add(str);
			}
			traverse(node.middle, strList, str);
			str = str.substring(0, str.length() - 1);
			traverse(node.right, strList, str);
		}
		return strList;
	}

	/**
	 * Returns All strings stored in the TST
	 */
	@Override
	public String toString() {
		return "" + traverse(root, "");
	}

}
