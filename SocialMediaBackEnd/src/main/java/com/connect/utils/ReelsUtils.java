package com.connect.utils;

import com.connect.model.Reels;
import com.connect.model.User;

import java.util.List;
import java.util.Set;

public class ReelsUtils {
    public static boolean isLikedByReqUser(Reels reel, User reqUser) {

        Set<User> like=reel.getLiked();

        for(User user:like) {
            if(user.getId()==reqUser.getId()) {
                return true;
            }
        }

        return false;

    }

    public static boolean isSaved(Reels reel,User user) {

        List<Reels> reqUsersReels=user.getSavedReels();

        for(Reels item : reqUsersReels) {
            if(item.getId()==reel.getId()) {
                return true;
            }
        }

        return false;
    }
}
