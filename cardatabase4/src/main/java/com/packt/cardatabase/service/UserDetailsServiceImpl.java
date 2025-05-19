package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.AppUser;
import com.packt.cardatabase.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AppUserRepository repository;

    public UserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = repository.findByUsername(username);
        UserBuilder builder = null;
        if(user.isPresent()) {
            AppUser currentUser = user.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            // 그래서 이제 24번 라인에서 일종의 형변환을 해준겁니다 AppUser -> UserBuilder로
            builder.password(currentUser.getPassword()); // "passwoer"를 UserBuilder 자료형의 nuilder의 password에 대입
            builder.roles(currentUser.getRole());   // "USER"를 UserBuilder 자료형의 nuilder의 roles에 대입
        }else {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }

        return builder.build();
    }
}
