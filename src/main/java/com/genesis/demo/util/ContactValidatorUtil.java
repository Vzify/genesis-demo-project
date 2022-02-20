package com.genesis.demo.util;


import com.genesis.demo.dto.ContactDTO;
import com.genesis.demo.dto.ContactTypeDTO;

public class ContactValidatorUtil {
    public static boolean isValid(ContactDTO contactDTO){
        if(contactDTO.getContactTypeDTO() == ContactTypeDTO.EMPLOYEE && contactDTO.getVat() != null){
            return false;
        }
        return contactDTO.getContactTypeDTO() != ContactTypeDTO.FREELANCE ||
                contactDTO.getVat() != null &&
                !contactDTO.getVat().isEmpty();
    }
}
