package com.item;

import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;


public class ItemRecommend {

    public ItemRecommend() {

    }

    static URI getPath() throws URISyntaxException {
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).toString();
        System.out.println(path);
        path += "heat.csv";
        URI uri = new URI(path);
        //System.out.println(path);  return path; }
        System.out.println(uri);
        return uri;
    }

    public List<RecommendedItem> getRecommendations(String userid, int number) {
        List<RecommendedItem> recommendations = null;
        FileDataModel model = null;
        try {
            URI uri = getPath();
            File file = new File(uri);
            model = new FileDataModel(file);
            //构造数据模型，File-based
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//计算内容相似度
            Recommender recommender = new GenericItemBasedRecommender(model, similarity);//构造推荐引擎
            recommendations = recommender.recommend(Long.parseLong(userid), number);//为用户542推荐10个物品
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommendations;
    }
}



