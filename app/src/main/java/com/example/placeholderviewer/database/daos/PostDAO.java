package com.example.placeholderviewer.database.daos;

import com.example.placeholderviewer.entities.Post;

import java.util.List;

public class PostDAO implements BaseDAO<Post> {
    @Override
    public Post select(Long id) {
        return null;
    }

    @Override
    public List<Post> select() {
        return null;
    }

    @Override
    public Post insert(Post item) {
        return null;
    }

    @Override
    public boolean update(Post item) {
        return false;
    }

    @Override
    public boolean delete(Post item) {
        return false;
    }
}
