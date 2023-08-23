package com.ecommerce.UserDetails.Service;

import com.ecommerce.UserDetails.Mapper.UserMapper;
import com.ecommerce.UserDetails.Repository.UserRepository;
import com.ecommerce.UserDetails.dto.UserRequest;
import com.ecommerce.UserDetails.dto.UserResponse;
import com.ecommerce.UserDetails.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserServiceInterface {
    private UserRepository userRepository;
    @Override
    public List<UserResponse> getUserList() {
        List<User> userList =userRepository.findAll();
        return userList.stream().map(UserMapper::mapUserResponseToUser).collect(Collectors.toList());
    }

    @Override
    public UserRequest createUser(UserRequest user) {
        User userDetail = UserMapper.mapUserToUserRequest(user);
        User saveUser = userRepository.save(userDetail);

        return UserMapper.mapUserRequestToUser(saveUser);
    }

    @Override
    public UserResponse updateUser(UserRequest user, int id) {
        Optional<User> isUser = userRepository.findById(id);
        if(isUser.isPresent())
        {
            User userDetail = isUser.get();
            userDetail.setName(user.getName());
            userDetail.setEmail(user.getEmail());
            userDetail.setPhone(user.getPhone());
            User UpdatedUser = userRepository.save(userDetail);
            return UserMapper.mapUserResponseToUser(UpdatedUser);
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
