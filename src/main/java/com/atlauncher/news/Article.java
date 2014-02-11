package com.atlauncher.news;

public final class Article{
	private final String title;
	private final String link;
	private final String content;
	private final int comments;
	
	private Article(String title, String link, String contents, int comments){
		this.title = title;
		this.link = link;
		this.content = contents;
		this.comments = comments;
	}
}