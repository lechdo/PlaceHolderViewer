package com.example.placeholderviewer.utils;

import com.example.placeholderviewer.entities.Comment;
import com.example.placeholderviewer.entities.Post;
import com.example.placeholderviewer.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Bouchon {

    public static List<Post> getPosts() {
        final List<Comment> comments = new ArrayList<Comment>(){{
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
            add(new Comment("juju", "je suis completement d'accord", null));
        }};

        return new ArrayList<Post>(){{
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
            add(new Post( new User(){{ setUserName("julien"); setName("Vince");}},"The Com", "ceci est un commentaire", comments));
        }};
    }
}
