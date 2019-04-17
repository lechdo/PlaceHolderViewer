package com.example.placeholderviewer.database.daos;

import com.example.placeholderviewer.entities.Comment;

import java.util.List;

public class CommentDAO implements BaseDAO<Comment> {
    @Override
    public Comment select(Long id) {
        return null;
    }

    @Override
    public List<Comment> select() {
        return null;
    }

    @Override
    public Comment insert(Comment item) {
        return null;
    }

    @Override
    public boolean update(Comment item) {
        return false;
    }

    @Override
    public boolean delete(Comment item) {
        return false;
    }
}
