package com.example.wbdvprojectsf19javaservergroup13.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shows")
public class Show {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int tvShowId;

  private String img;

  private String name;

  private Timestamp updated;

  private String language;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTvShowId() {
    return tvShowId;
  }

  public void setTvShowId(int tvShowId) {
    this.tvShowId = tvShowId;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Timestamp getUpdated() {
    return updated;
  }

  public void setUpdated(Timestamp updated) {
    this.updated = updated;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
