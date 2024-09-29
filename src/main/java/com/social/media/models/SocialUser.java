package com.social.media.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    //@JoinColumn(name = "social_profile_id")
    private SocialProfile socialProfile;

    // One to many

    @OneToMany(mappedBy = "socialUser")
    private List<Post> posts = new ArrayList<>();
}
