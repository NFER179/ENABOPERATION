package com.app.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeStructure<T> implements Iterable<T> {
	
	private TreeStructure<T> _tsParent;
	private T _tElement;
	private List<TreeStructure<T>> _ltsChildren;
	
	public TreeStructure() {
		this._tsParent = null;
		this._tElement = null;
		this._ltsChildren = new ArrayList<TreeStructure<T>>();
	}
	
	public TreeStructure(T element) {
		this._tsParent = null;
		this._tElement = element;
		this._ltsChildren = new ArrayList<TreeStructure<T>>();
	}
	
	public TreeStructure(T element, TreeStructure<T> parent) {
		this._tsParent = parent;
		this._tElement = element;
		this._ltsChildren = new ArrayList<TreeStructure<T>>();
	}
	
	public void addChilndren(TreeStructure<T> tree) {
		tree.addFather(this);
		this._ltsChildren.add(tree);
	}
	
	public void addFather(TreeStructure<T> tree) {
		this._tsParent = tree;
	}
	
	public List<TreeStructure<T>> getCompleteBranch(T element) {
		List<TreeStructure<T>> branch = new ArrayList<TreeStructure<T>>();
		
		branch = this.recursividad("", this, element);
		
		return branch;
	}
	
	/* It is possible to improve, add the parameter break. */
	private List<TreeStructure<T>> recursividad(String tab, TreeStructure<T> ts, T element) {
		List<TreeStructure<T>> list = new LinkedList<TreeStructure<T>>();
		
		/* Base Case. */
		for (TreeStructure<T> tsChildren: ts._ltsChildren) {
			if (tsChildren.getElement().equals(element)) {
				list.addAll(this.getPathToRoot(tsChildren));
				break;
			} else {
				list.addAll(recursividad(tab + "\t", tsChildren, element));
			}
		}
		return list;
	}
	
	public T getElement() {
		return this._tElement;
	}
	
	public LinkedList<TreeStructure<T>> getPathToRoot(TreeStructure<T> ts) {
		LinkedList<TreeStructure<T>> list = new LinkedList<TreeStructure<T>>();
		
		list.add(ts);
		
		if (ts.haveParent()) {
			this.addFatherToList(list);
		}
		
		return list;
	}
	
	private LinkedList<TreeStructure<T>> addFatherToList(LinkedList<TreeStructure<T>> t){
		
		if (t.getFirst().haveParent()) {
			t.addFirst(t.getFirst().getParent());
			this.addFatherToList(t);			
		}
		
		return t;
	}
	
	
	/* Overrides. */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/* Boolean. */
	public boolean haveParent() {
		return this._tsParent != null;
	}
	
	
	/* Getters and Setters. */
	public void setElement(T element) {
		this._tElement = element;
	}
	
	public TreeStructure<T> getParent() {
		return this._tsParent;
	}
	
	public List<TreeStructure<T>> getChildren() {
		return this._ltsChildren;
	}
	
	/* to delete */
	@Override
	public String toString() {
		String information="";
		
		if (_tsParent == null) {
			information += "TreeStructure ["
					+ "\n\t_tsParent: " + null + ", "
					+ "\n\t_tElement: " + this._tElement + ", "
					+ "\n\t_ltsChildren: " + this._ltsChildren + "]";
		} else {
			information += "TreeStructure ["
					+ "\n\t_tsParent: " + this._tsParent.getElement() + ", "
					+ "\n\t_tElement: " + this._tElement + ", "
					+ "\n\t_ltsChildren: " + this._ltsChildren + "]";			
		}
		
		return information;
		
	}
}
