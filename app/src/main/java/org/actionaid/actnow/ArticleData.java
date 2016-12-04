package org.actionaid.actnow;

/**
 * Created by Ahmed on 03-Dec-16.
 */

public class ArticleData {
    private String id;
    private String date;
    private String title;
    private String body;

    public ArticleData(String id, String date, String title, String body){
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }
    public String getId(){
        return id;
    }
    public String getDate(){
        return date;
    }
    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }
}
