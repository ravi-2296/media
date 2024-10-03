package com.social.media;

import com.social.media.models.Post;
import com.social.media.models.SocialGroup;
import com.social.media.models.SocialProfile;
import com.social.media.models.SocialUser;
import com.social.media.repository.PostRepository;
import com.social.media.repository.SocialGroupRepository;
import com.social.media.repository.SocialProfileRepository;
import com.social.media.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final SocialGroupRepository socialGroupRepository;
    private final PostRepository postRepository;

// Initialized using Constructor
    // We can iniialize using the property just We have to give @Autowired.

    public DataInitializer(SocialUserRepository userRepository, SocialProfileRepository socialProfileRepository, SocialGroupRepository socialGroupRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.postRepository = postRepository;
    }

    // Initializing the beans
    @Bean
    public CommandLineRunner initializeData() {
        return args -> {

            // Create Some Users

            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to database

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            //Create Some Groups

            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Associate Users with group
            user1.getSocialGroups().add(group1);
            user1.getSocialGroups().add(group2);

            user2.getSocialGroups().add(group2);
            user3.getSocialGroups().add(group2);

            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            // Save users back tp database to update Associations

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);




            // Create Some Posts

            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Save the posts to the database

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Create some Social profiles

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate the profile with the user
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save the profiles to the databases

            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);
        };
    }
}
