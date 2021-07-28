package com.allstate.crimsoncherry.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sex;
    private String hometown;
    private long height;
    private String name;
    private long children;
    private String birthday;

    public Actor(){}

    public Actor(Long id, String sex, String hometown, long height, String name, long children, String birthday) {
        this.id = id;
        this.sex = sex;
        this.hometown = hometown;
        this.height = height;
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", hometown='" + hometown + '\'' +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", children=" + children +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return getHeight() == actor.getHeight() && getChildren() == actor.getChildren() && Objects.equals(getId(), actor.getId()) && Objects.equals(getSex(), actor.getSex()) && Objects.equals(getHometown(), actor.getHometown()) && Objects.equals(getName(), actor.getName()) && Objects.equals(getBirthday(), actor.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSex(), getHometown(), getHeight(), getName(), getChildren(), getBirthday());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getChildren() {
        return children;
    }

    public void setChildren(long children) {
        this.children = children;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}