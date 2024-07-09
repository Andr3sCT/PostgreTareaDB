package com.apx.school.service;

import com.apx.school.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class UserService {

    private Map<Long, UserDto> list = new HashMap<Long, UserDto>();
    private Long id = 1L;

    public List<UserDto> getAll(){
        return new ArrayList<UserDto>(list.values());
    }

    public UserDto getById(Long id){
        return list.get(id);
    }

    public UserDto save(UserDto user){
        user.setId(id);
        list.put(user.getId(), user);
        id++;
        return user;
    }

    public UserDto update(UserDto user, Long id){
        if (list.containsKey(id)){
            user.setId(id);
            list.put(user.getId(), user);
            return user;
        } else {
            return null;
        }
    }

    public void delete(Long id){
        list.remove(id);
    }
}
