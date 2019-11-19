package com.briup.bean;

import java.util.Date;

public class Article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.title
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.content
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.source
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private String source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.publish_time
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Date publishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.read_time
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Integer readTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.status
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.thumb_up
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Integer thumbUp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.thumb_down
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Integer thumbDown;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.author_id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Integer authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.category_id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    private Integer categoryId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.id
     *
     * @return the value of cms_article.id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.id
     *
     * @param id the value for cms_article.id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.title
     *
     * @return the value of cms_article.title
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.title
     *
     * @param title the value for cms_article.title
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.content
     *
     * @return the value of cms_article.content
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.content
     *
     * @param content the value for cms_article.content
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.source
     *
     * @return the value of cms_article.source
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.source
     *
     * @param source the value for cms_article.source
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.publish_time
     *
     * @return the value of cms_article.publish_time
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.publish_time
     *
     * @param publishTime the value for cms_article.publish_time
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.read_time
     *
     * @return the value of cms_article.read_time
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Integer getReadTime() {
        return readTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.read_time
     *
     * @param readTime the value for cms_article.read_time
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.status
     *
     * @return the value of cms_article.status
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.status
     *
     * @param status the value for cms_article.status
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.thumb_up
     *
     * @return the value of cms_article.thumb_up
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Integer getThumbUp() {
        return thumbUp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.thumb_up
     *
     * @param thumbUp the value for cms_article.thumb_up
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.thumb_down
     *
     * @return the value of cms_article.thumb_down
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Integer getThumbDown() {
        return thumbDown;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.thumb_down
     *
     * @param thumbDown the value for cms_article.thumb_down
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setThumbDown(Integer thumbDown) {
        this.thumbDown = thumbDown;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.author_id
     *
     * @return the value of cms_article.author_id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.author_id
     *
     * @param authorId the value for cms_article.author_id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.category_id
     *
     * @return the value of cms_article.category_id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.category_id
     *
     * @param categoryId the value for cms_article.category_id
     *
     * @mbg.generated Fri Nov 15 17:32:47 CST 2019
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}