package com.social.media.models;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SocialUser socialUser;
}
