package com.ltt;


import com.alibaba.fastjson.JSONObject;
import com.item.ItemRecommend;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ActionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
        String userid = new String(request.getParameter("userid").getBytes("ISO8859-1"), StandardCharsets.UTF_8);
        String number = new String(request.getParameter("number").getBytes("ISO8859-1"), StandardCharsets.UTF_8);
        ItemRecommend itemRecommend = new ItemRecommend();
        List<RecommendedItem> recommendations = null;
        recommendations = itemRecommend.getRecommendations(userid, Integer.parseInt(number));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JSONObject jsonObject = new JSONObject();
            if (recommendations == null) {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "请求失败");
            } else {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "请求成功");
            }
            jsonObject.put("data", recommendations);
            out.write(jsonObject.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
