package com.example.sentiment_app.api;

import com.example.sentiment_app.model.Text;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class APIHandler {
    @Autowired
    private ExternalAPI api;

    public Text APIHandler(Text text) throws IOException, InterruptedException, JSONException {

        JSONObject APIInfo = new JSONObject(api.postRequest(text));

        text.setSentiment(APIInfo.getString("sentiment"));

        JSONArray newObject= new JSONArray(APIInfo.getString("sentiment_list"));
        System.out.println(newObject);
        for (String v: newObject.toString().split(",")) {
            if(v.contains("sentence")){
                System.out.println(v);
                text.setSentence(v.substring(14));
                break;
            }
        }

        JSONObject aggregate = new JSONObject(APIInfo.getString("aggregate_sentiment"));

        text.setNeg(Double.parseDouble(aggregate.getString("neg")));
        text.setNeu(Double.parseDouble(aggregate.getString("neu")));
        text.setPos(Double.parseDouble(aggregate.getString("pos")));
        text.setDate(java.time.LocalDate.now());

        return text;

    }
}
