package com.example.sentiment_app.api;

import com.example.sentiment_app.command.TextDto;
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

    private Text text;

    public APIHandler(Text text) {
        this.text = text;
    }

    public Text APIHandler(String message) throws IOException, InterruptedException, JSONException {


        JSONObject saveSentiment = new JSONObject(api.postRequest(message));

        text.setSentiment(saveSentiment.getString("sentiment"));

        JSONArray newObject= new JSONArray(saveSentiment.getString("sentiment_list"));
        System.out.println("_________________");
        System.out.println(newObject.getString(0));
        System.out.println("_________________");


        JSONObject newObject2= new JSONObject(newObject.getString(0));

        System.out.println("_________________");
        System.out.println(newObject2.getString("sentence"));
        System.out.println("_________________");

        for (String v: newObject2.toString().split(",")) {
            if(v.contains("sentence=")){
                text.setSentence(v.substring(10));
                break;
            }
            System.out.println(v);
        }

        JSONObject saveTextAPIInfo = new JSONObject(api.postRequest(message));

        JSONObject aggregate = new JSONObject(saveTextAPIInfo.getString("aggregate_sentiment"));

        text.setNeg(Double.parseDouble(aggregate.getString("neg")));
        text.setNeu(Double.parseDouble(aggregate.getString("neu")));
        text.setPos(Double.parseDouble(aggregate.getString("pos")));
        //text.setSentence(aggregate.getString("sentence"));

        return text;

    }
}
