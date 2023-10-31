package com.example.Hospital.Management.System.Kashifa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse){
        if(nurse.getNurseId()<0){
            return "Enter a valid nurseId";

        }
        if (nurse.getName().equals(null)) {

            return "Name shoukd not be null";
        }
        String ans= nurseRepository.addNurse(nurse);
        return ans;
    }
    public List<Nurse> getList(int age){
        List<Nurse> finalList=new ArrayList<>();
        List<Nurse> nurses=nurseRepository.getAllNurses();
        for(Nurse nurse : nurses){
            if(nurse.getAge()>age){
                finalList.add(nurse);
            }

        }
        return finalList;
    }
    public List<Nurse> getNurseWithQualification(String qualification){
        List<Nurse> nurseList=nurseRepository.getAllNurses();
        List<Nurse> nurses = new ArrayList<>();
        for(Nurse nurse :nurseList){
            if(nurse.getQualification().equals(qualification)){
                nurses.add(nurse);
            }
        }
        return nurses;
    }

}
