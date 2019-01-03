package pojo;


import java.sql.Date;

public class Announcement {

  private long id;
  private String anTitle;
  private String anText;
  private java.sql.Date anDate;

  public Announcement() {
  }

  public Announcement(long id, String aTitle, String aText, Date aDate) {

    this.id = id;
    this.anTitle = aTitle;
    this.anText = aText;
    this.anDate = aDate;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAnTitle() {
    return anTitle;
  }

  public void setATitle(String aTitle) {
    this.anTitle = aTitle;
  }


  public String getAnText() {
    return anText;
  }

  public void setAText(String aText) {
    this.anText = aText;
  }


  public java.sql.Date getAnDate() {
    return anDate;
  }

  public void setADate(java.sql.Date aDate) {
    this.anDate = aDate;
  }

}
