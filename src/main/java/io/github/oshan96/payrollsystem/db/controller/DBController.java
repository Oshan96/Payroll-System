package io.github.oshan96.payrollsystem.db.controller;

import io.github.oshan96.payrollsystem.model.db.DBModel;

/**
 * @author oshan
 */
public interface DBController<T extends DBModel> {
    boolean add(T t) throws Exception;
    T get(String id) throws Exception;
    boolean delete(String id) throws Exception;
    boolean update(T t) throws Exception;
}
