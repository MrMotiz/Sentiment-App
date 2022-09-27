package com.example.sentiment_app.api;

import com.example.sentiment_app.model.Text;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class APIHandler {
    ExternalAPI api = new ExternalAPI();
    Text text = new Text();


    public APIHandler() throws IOException, InterruptedException, JSONException {

        JSONObject myJsonObj = new JSONObject(api.postRequest(text.toString()));

        text.setSentiment(myJsonObj.getString("sentiment"));

        String sentimentList = myJsonObj.getString("aggregate_sentiment");


        JSONObject aggregate = new JSONObject(sentimentList);

        text.setNeg(Double.parseDouble(aggregate.getString("neg")));
        text.setNeu(Double.parseDouble(aggregate.getString("neu")));
        text.setPos(Double.parseDouble(aggregate.getString("pos")));
    }
}
