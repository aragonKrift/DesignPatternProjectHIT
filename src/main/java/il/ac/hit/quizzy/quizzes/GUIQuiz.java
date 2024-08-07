package il.ac.hit.quizzy.quizzes;

import il.ac.hit.quizzy.Answer;
import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.IQuizQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A GUI based quiz.
 */
public class GUIQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions;
    private int score;
    private int currentQuestionIndex;
    private final JFrame frame;

    public GUIQuiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.frame = new JFrame();
    }

    @Override
    public void start() {
        //initialize the GUI window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showQuestions(currentQuestionIndex);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.frame.setTitle(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addQuestion(IQuizQuestion question) {
        this.questions.add(question);
    }

    @Override
    public List<IQuizQuestion> getQuestions() {
        return questions;
    }

    private void showQuestions(int index) {
        //if we reach the end of the quiz, show the score
        if (index >= questions.size()) {
            showResults();
            return;
        }

        //show the current question
        IQuizQuestion question = questions.get(index);
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(question.getQuestionText());
        questionPanel.add(questionLabel);

        //add radio button for the user to choose an answer
        ButtonGroup group = new ButtonGroup();
        List<Answer> options = question.getAnswers();
        List<JRadioButton> radioButtons = new ArrayList<>();

        for (int i = 0; i < options.size(); i++) {
            JRadioButton radioButton = new JRadioButton(options.get(i).getText());
            radioButton.setActionCommand(String.valueOf(i));
            group.add(radioButton);
            radioButtons.add(radioButton);
            questionPanel.add(radioButton);
        }

        //submit answer button
        JButton submitButton = getJButton(radioButtons, question);

        frame.add(questionPanel, BorderLayout.CENTER);
        frame.add(submitButton, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }

    private JButton getJButton(List<JRadioButton> radioButtons, IQuizQuestion question) {
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            int selectedAnswerIndex = -1;
            for (int i = 0; i < radioButtons.size(); i++) {
                if (radioButtons.get(i).isSelected()) {
                    selectedAnswerIndex = i;
                    break;
                }
            }

            //if the answer is correct, add a point to the score and move to the next question
            if (selectedAnswerIndex != -1 && question.getAnswers().get(selectedAnswerIndex).isCorrect()) {
                score++;
            }
            currentQuestionIndex++;
            showQuestions(currentQuestionIndex);
        });
        return submitButton;
    }

    private void showResults() {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("Quiz finished! Your score: " + score + "/" + questions.size());
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(resultLabel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public IQuiz clone() {
        try {
            //return a prototype of the quiz with the questions
            GUIQuiz clone = (GUIQuiz) super.clone();
            clone.questions = new ArrayList<>(this.questions);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
