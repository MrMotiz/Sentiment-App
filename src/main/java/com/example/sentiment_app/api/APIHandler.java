package com.example.sentiment_app.api;

import com.example.sentiment_app.command.TextDto;
import com.example.sentiment_app.model.Text;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class APIHandler {
    @Autowired
    private ExternalAPI api;

    private Text text;

    public APIHandler(Text text) {
        this.text = text;
    }

    public void APIHandler(String message) throws IOException, InterruptedException, JSONException {

        JSONObject myJsonObj = new JSONObject(api.postRequest(message));

        text.setSentiment(myJsonObj.getString("sentiment"));
        System.out.println(text.getSentiment());
        text.setSentiment(myJsonObj.get("sentiment").toString());
        System.out.println(text.getSentiment());

        String sentimentList = myJsonObj.getString("aggregate_sentiment");

        JSONObject aggregate = new JSONObject(sentimentList);

        text.setNeg(Double.parseDouble(aggregate.getString("neg")));
        text.setNeu(Double.parseDouble(aggregate.getString("neu")));
        text.setPos(Double.parseDouble(aggregate.getString("pos")));

    }
}
