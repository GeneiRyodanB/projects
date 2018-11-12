package com.zerohunger.geneiryodan.feedapp.models.actions;

import java.util.Map;


public class Besoin {

	private Long Id;

	private Map<Article, Integer> articlesQuantity;

	private Action action;
	
	public Besoin() {
		
	}
	
	public Besoin(Long Id, Map<Article, Integer> articlesQuantity, Action action) {
		this.Id = Id;
		this.articlesQuantity = articlesQuantity;
		this.action = action;
	}

	public Map<Article, Integer> getArticlesQuantity() {
		return articlesQuantity;
	}

	public void setArticlesQuantity(Map<Article, Integer> articlesQuantity) {
		this.articlesQuantity = articlesQuantity;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int size() {
		return articlesQuantity.size();
	}

	public boolean isEmpty() {
		return articlesQuantity.isEmpty();
	}

	public Integer get(Object key) {
		return articlesQuantity.get(key);
	}

	public Integer put(Article key, Integer value) {
		return articlesQuantity.put(key, value);
	}

	public Integer remove(Object key) {
		return articlesQuantity.remove(key);
	}

	public void putAll(Map<? extends Article, ? extends Integer> m) {
		articlesQuantity.putAll(m);
	}

	public void clear() {
		articlesQuantity.clear();
	}
	
	
	
	
}
