package com.item;


import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

/**
 * 基于用户的推荐
 */
public class UserRecommend {
    public UserRecommend() {
    }

    private static URI getPath() throws URISyntaxException {
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).toString();
        System.out.println(path);
        path += "heat.csv";
        URI uri = new URI(path);
        System.out.println(uri);
        return uri;
    }

    public List<RecommendedItem> getRecommendations(String userid, int number) throws TasteException, URISyntaxException {
        URI uri = getPath();
        DataModel model = null;//加载数据文件
        UserSimilarity similarity;
        UserNeighborhood neighborhood;
        Recommender recommender = null;
        try {
            model = new FileDataModel(new File(uri));
            similarity = new PearsonCorrelationSimilarity(model);  //建立推荐模型
            neighborhood = new NearestNUserNeighborhood(10, similarity, model);
            recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert recommender != null;
        return recommender.recommend(Long.parseLong(userid), number);
    }


}

