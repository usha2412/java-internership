import java.util.List;

public class Quiz {
    private String question;
    private List<String> options;
    private int correctOption;

    public Quiz(String question, List<String> options) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }
    public   int getCorrectOption() {
        return correctOption;
    }

    public  void displayQuestion(){
        System.out.println(question);
        for(int i=0; i<options.size(); i++){
            System.out.println((i+1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int userAnswer){
        return userAnswer == correctOption;
    }

    public String getCorrectAnswer(){
        return options.get(correctOption -1);
    }

    public String getQuestionText(){
        return question;
    }



}
