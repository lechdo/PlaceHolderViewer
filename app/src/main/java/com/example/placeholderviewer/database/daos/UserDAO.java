package com.example.placeholderviewer.database.daos;

import com.example.placeholderviewer.entities.User;

import java.util.List;

public class UserDAO implements BaseDAO<User> {
    @Override
    public User select(Long id) {
        return null;
    }

    @Override
    public List<User> select() {
        return null;
    }

    @Override
    public User insert(User item) {
        return null;
    }

    @Override
    public boolean update(User item) {
        return false;
    }

    @Override
    public boolean delete(User item) {
        return false;
    }
}
