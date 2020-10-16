package maksim.moiseenko;


import lombok.RequiredArgsConstructor;
import maksim.moiseenko.models.Account;
import maksim.moiseenko.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account userModel = userRepository.findByLogin(s)
                .orElseThrow(() -> new UsernameNotFoundException("This username " + s + " was not found "));

        return new User(userModel.getLogin(), userModel.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(userModel.getRole())));
    }
}
