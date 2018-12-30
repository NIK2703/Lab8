package sample;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Questions {

    Map<String,Integer> questions = new LinkedHashMap<>();
    Random rand = new Random();
    ArrayList<String> Qlist;
    ArrayList<Integer> Qans;

    int currentQuestion;


    Questions(){
        questions.put("Сколько будет 2^11?",2048);
        questions.put("Сколько океанов на Земле?",4);
        questions.put("Какова высота Эвереста (м)?",8848);
        questions.put("Сколько дней в году?",365);

        Qlist = new ArrayList<String>(questions.keySet());
        Qans = new ArrayList<Integer>(questions.values());

    }

    String nextQuestion(){
        currentQuestion = rand.nextInt(questions.size());
        return Qlist.get(currentQuestion);
    }

    String getAnswer(int answer){
        if(answer == Qans.get(currentQuestion)){
            return new String ("Правильный ответ!");
        }
        else {
            return new String ("Неверно. Ответ: " + Qans.get(currentQuestion));
        }
    }



}
