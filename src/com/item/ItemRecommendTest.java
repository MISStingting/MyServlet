package com.item;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;


public class ItemRecommendTest {

    public static void main(String[] args) {
        List<RecommendedItem> recommendations = null;
        ItemRecommend itemRecommend = new ItemRecommend();
        recommendations = itemRecommend.getRecommendations("10042781", 10);
        if (recommendations != null) {
            for (RecommendedItem recommendedItem : recommendations) {
                System.out.println("\n推荐物品：" + recommendedItem.getItemID());
                System.out.println("推荐得分:" + recommendedItem.getValue());

            }
        }
    }

}



