package com.example.placeholderviewer.database;

import com.example.placeholderviewer.database.daos.AdressDAO;
import com.example.placeholderviewer.database.daos.BaseDAO;
import com.example.placeholderviewer.database.daos.CommentDAO;
import com.example.placeholderviewer.database.daos.CompagnyDAO;
import com.example.placeholderviewer.database.daos.GeoDAO;
import com.example.placeholderviewer.database.daos.PostDAO;
import com.example.placeholderviewer.database.daos.UserDAO;
import com.example.placeholderviewer.entities.Adress;
import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.entities.Compagny;
import com.example.placeholderviewer.entities.Geo;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.entities.User;

public class DbManager {

    private BaseDAO<User> UserDAO;
    private BaseDAO<Post> PostDAO;
    private BaseDAO<Adress> AdressDAO;
    private BaseDAO<Comment> CommentDAO;
    private BaseDAO<Compagny> CompagnyDAO;
    private BaseDAO<Geo> GeoDAO;

    public BaseDAO<Post> getPostDAO() {
        if (PostDAO == null) {
            PostDAO = new PostDAO();
        }
        return PostDAO;
    }

    public BaseDAO<Adress> getAdressDAO() {
        if (AdressDAO == null) {
            AdressDAO = new AdressDAO();
        }
        return AdressDAO;
    }

    public BaseDAO<Comment> getCommentDAO() {
        if (CommentDAO == null) {
            CommentDAO = new CommentDAO();
        }
        return CommentDAO;
    }

    public BaseDAO<Compagny> getCompagnyDAO() {
        if (CompagnyDAO == null) {
            CompagnyDAO = new CompagnyDAO();
        }
        return CompagnyDAO;
    }

    public BaseDAO<Geo> getGeoDAO() {
        if (GeoDAO == null) {
            GeoDAO = new GeoDAO();
        }
        return GeoDAO;
    }

    public BaseDAO<User> getUserDAO() {
        if (UserDAO == null) {
            UserDAO = new UserDAO();
        }
        return UserDAO;
    }

    public DbManager() {

    }
}
