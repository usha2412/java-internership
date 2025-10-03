import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Quiz> questions = new ArrayList<>();
        questions.add(new Quiz(
                "What is the capital of India?",
                Arrays.asList("Mumbai", "Delhi", "Kolkata", "Chennai")
        ));
        questions.add(new Quiz(
                "Which language is used for Android development?",
                Arrays.asList("Python", "Java", "C#", "Swift")
        ));
        questions.add(new Quiz(
                "Who is known as the father of Java?",
                Arrays.asList("James Gosling", "Bjarne Stroustrup", "Guido van Rossum", "Dennis Ritche")
        ));
        questions.add(new Quiz(
                "What is the capital of France?",
                Arrays.asList("Paris", "London", "Berlin", "Madrid")
        ));
        int score =0;

        List<Quiz> wrongAnswers = new ArrayList<>();
        List<Integer> userWrongChoices = new ArrayList<>();

        System.out.println("===== Welcome to the Quiz Section =====\n");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Q" + (i + 1) + ": ");
            questions.get(i).displayQuestion();

            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();

            if (questions.get(i).checkAnswer(answer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong!\n");
                wrongAnswers.add(questions.get(i));
                userWrongChoices.add(answer);
            }
        }

        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        if (!wrongAnswers.isEmpty()) {
            System.out.println("\n--- Review Your Mistakes ---");
            for (int i = 0; i < wrongAnswers.size(); i++) {
                Quiz q = wrongAnswers.get(i);
                int chosen = userWrongChoices.get(i);
                System.out.println("Q: " + q.getQuestionText());
                System.out.println("❌ Your Answer: " +
                        (chosen >= 1 && chosen <= q.getOptions().size() ? q.getOptions().get(chosen - 1) : "Invalid choice"));
                System.out.println("✅ Correct Answer: " +q.getCorrectAnswer());
                System.out.println();
            }
        }

        scanner.close();

    }
}