package com.jo.healthcare.services;

import com.jo.healthcare.buisnessObjects.User;

public interface UserServicesInterface {
	
	
    public  void changeContactDetails(User user, String mobileNumber, String email);
    public void  displayContactDetails(User user);

    public  void changeUserName(User user, String newUserName);
}
