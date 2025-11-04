package com.smartevent_backend.project.serviceImpl;

import com.smartevent_backend.project.exception.FieldAlreadyExist;
import com.smartevent_backend.project.exception.FieldNotFound;
import com.smartevent_backend.project.model.Right;
import com.smartevent_backend.project.repository.RightRepository;
import com.smartevent_backend.project.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightRepository rightRepository;

    @Override
    public Right addRight(String rightName) {
        if(rightRepository.existsById(createRightId(rightName)))
            throw new FieldAlreadyExist("right already exist with the specified name");
        Right right=new Right();
        right.setRightId(createRightId(rightName));
        right.setName(rightName);
        right.setGroupName(createGroupId(rightName));
        rightRepository.save(right);
        return right;
    }

    @Override
    public Right getRight(String rightName) {
        return rightRepository.findById(createRightId(rightName)).orElseThrow(()-> new FieldNotFound("no right with the specified name"));
    }

    @Override
    public List<Right> getRights() {
        return rightRepository.findAll();
    }

    @Override
    public void deleteRight(String rightName) {
        if(rightRepository.existsById(createRightId(rightName))){
            rightRepository.deleteById(createRightId(rightName));
        }
        else throw new FieldNotFound("no right with the specified name");
    }
    // method for creating and getting right id using the rightName
    public String createRightId(String rightName){

        if (rightName == null || rightName.isBlank()) {
            throw new IllegalArgumentException("Right name cannot be null or empty");
        }

        StringBuilder rightId= new StringBuilder();
        for(String word:rightName.split(" ")){
            rightId.append(word.charAt(0));
        }
        if(rightRepository.existsById(rightId.toString())){
            int hash = Math.abs(rightName.hashCode() % 10000);
            rightId.append("_").append(hash);
        }
        return rightId.toString().toLowerCase();
    }
    //method for creating and getting group name using rightName
    public String createGroupId(String rightName){
        String[] phrase=rightName.split(" ");
        return phrase[phrase.length-1].toUpperCase();
    }
}
