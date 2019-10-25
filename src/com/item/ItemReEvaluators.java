package com.item;

import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;


import java.io.File;
import java.net.URI;
import java.util.List;

import static com.item.ItemRecommend.getPath;

public class ItemReEvaluators {

    public static void main(String[] args) throws Exception {
        URI uri = getPath();
        DataModel model = new FileDataModel(new File(uri));

        RecommenderBuilder recommenderBuilder = dataModel -> {
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
            return new GenericItemBasedRecommender(model, similarity);
        };
        //获取推荐结果
//        List<RecommendedItem> recommendations = recommenderBuilder.buildRecommender(model).recommend(10002308, 4);
//
//        for (RecommendedItem recommendation : recommendations) {
//            System.out.println(recommendation);
//        }

        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        double score = evaluator.evaluate(recommenderBuilder, null, model, 0.9, 1.0);
        System.out.println(score);
        //计算查全率和查准率
        RecommenderIRStatsEvaluator statsEvaluator = new GenericRecommenderIRStatsEvaluator();
        // Evaluate precision and recall "at 2":
        IRStatistics stats = statsEvaluator.evaluate(recommenderBuilder, null, model, null, 5,
                GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD,
                1.0);
        System.out.println(stats.getPrecision());
        System.out.println(stats.getRecall());


    }

}