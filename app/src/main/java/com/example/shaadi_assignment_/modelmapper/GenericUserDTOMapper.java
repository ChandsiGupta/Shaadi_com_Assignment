package com.example.shaadi_assignment_.modelmapper;

import com.example.shaadi_assignment_.dto.GenericUserDTO;
import com.example.shaadi_assignment_.model.Result;
import com.example.shaadi_assignment_.model.database.User;

public class GenericUserDTOMapper {
    public static GenericUserDTO userToGenericUserDTOMapper(User user) {
        GenericUserDTO genericUserDTO = new GenericUserDTO();
        genericUserDTO.setGender(user.getGender());
        genericUserDTO.setFirst(user.getFirst());
        genericUserDTO.setLast(user.getLast());
        genericUserDTO.setLocation(user.getStreet());
        genericUserDTO.setEmail(user.getEmail());
        genericUserDTO.setAge(user.getAge());
        genericUserDTO.setThumbnail(user.getThumbnail());
        genericUserDTO.setStatus(user.getStatus());
        return genericUserDTO;
    }
    
    public static GenericUserDTO userApiResponseToGenericUserDTOMapper(Result result) {
        GenericUserDTO genericUserDTO = new GenericUserDTO();
        genericUserDTO.setGender(result.getGender());
        genericUserDTO.setFirst(result.getName().getFirst());
        genericUserDTO.setLast(result.getName().getLast());
        genericUserDTO.setLocation(result.getLocation().getStreet().getName());
        genericUserDTO.setEmail(result.getEmail());
        genericUserDTO.setAge(result.getDob().getAge());
        genericUserDTO.setThumbnail(result.getPicture().getThumbnail());
        genericUserDTO.setStatus(null);
        return genericUserDTO;
    }
}
