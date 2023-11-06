package com.DataAccessObject;

import com.model.Person;

import java.util.ArrayList;

public interface DataInterface<T extends Person> {
    public int insert(T t);
    public int update(T t);
    public int delete(T t);
    public ArrayList<T> selectAll();
    public T selectById(T t);
}
