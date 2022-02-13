package com.nagarro.controller;

import java.util.*;

import com.nagarro.Models.*;
import com.nagarro.services.*;

public class GetImageSize {
	public static double getImagesSize(String username) {
        double totalSize = 0;
        LoginService login = new LoginService();
        User user = login.getUserDetails(username);
        Set<Image> images = user.getImages();
        for (Image image : images) {
            totalSize += image.getImageSize();
        }
        return totalSize;
    }
}
