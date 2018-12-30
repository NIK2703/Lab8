package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {

    Label question = new Label("Вопрос");
    Label answer = new Label("Ответ");

    Button ok = new Button("Ок");
    Button next = new Button(">>");

    Slider s1000 = new Slider(0,9,0);
    Slider s100 = new Slider(0,9,0);
    Slider s10 = new Slider(0,9,0);
    Slider s1 = new Slider(0,9,0);

    int sval1000 = 0;
    int sval100 = 0;
    int sval10 = 0;
    int sval1 = 0;

    Questions questions = new Questions();

    Integer currentNumber;

    String questionText = new String();
    String answerText = new String();

    @Override
    public void start(Stage primaryStage) throws Exception{

        questionText = questions.nextQuestion();
        question.setText(questionText);

        primaryStage.setTitle("Вопросы");

        question.setId("question");

        answer.setId("answer");

        ok.setId("ok");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                answerText = questions.getAnswer(currentNumber);
                answer.setText(answerText);


                questionText = questions.nextQuestion();
                question.setText(questionText);
            }
        });


        next.setId("next");
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                questionText = questions.nextQuestion();
                refresh();
            }
        });

        s1000.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                sval1000 = newValue.intValue();
                refresh();
            }
        });

        s100.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                sval100 = newValue.intValue();
                refresh();
            }
        });

        s10.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                sval10 = newValue.intValue();
                refresh();
            }
        });

        s1.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                sval1 = newValue.intValue();
                refresh();
            }
        });

        HBox hbox = new HBox(answer,next,ok);

        VBox root = new VBox(question,s1000,s100,s10,s1,hbox);

        Scene scene = new Scene(root, 480, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void refresh (){
        question.setText(questionText);

        currentNumber = sval1000*1000 + sval100*100 + sval10*10 + sval1*1;
        answerText = currentNumber.toString();
        answer.setText(answerText);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
