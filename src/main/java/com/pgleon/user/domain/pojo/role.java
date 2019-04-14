package com.pgleon.user.domain.pojo;

public class role {
   private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                '}';
    }
}
