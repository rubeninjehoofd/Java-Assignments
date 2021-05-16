package nl.schild.ruben.RubenfirstAPI.securtity;

import nl.schild.ruben.RubenfirstAPI.model.User;
import nl.schild.ruben.RubenfirstAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //find user by username
        User user = userRepository.findByUsername(s);

        //check if user exists
        if (user == null)
        {
            throw new UsernameNotFoundException("User " + s + " not found");
        }

        //parse the user details to user framework of spring
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(s)
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

        return userDetails;
    }
}
