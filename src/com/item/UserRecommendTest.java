package com.item;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

public class UserRecommendTest {
    public static void main(String[] args) throws Exception {
        UserRecommend userRecommend = new UserRecommend();
        List<RecommendedItem> recommendations = userRecommend.getRecommendations("10059014", 10);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }
}
