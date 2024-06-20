package il.ac.hit.quizzy.quizzes;

import il.ac.hit.quizzy.Answer;
import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.IQuizQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUIQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions;
    private int score;
    private int currentQuestionIndex;
    private JFrame frame;

    public GUIQuiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.frame = new JFrame("Quiz Application");
    }
    @Override
    public void start() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showQuestions(currentQuestionIndex);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void setName(String text) {
        this.name = text;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addQuestion(IQuizQuestion question) {
        this.questions.add(question);
    }

    private void showQuestions(int index) {
        if (index >= questions.size()) {
            showResults();
            return;
        }

        IQuizQuestion question = questions.get(index);
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel(question.getQuestionText());
        questionPanel.add(questionLabel);

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
            GUIQuiz clone = (GUIQuiz) super.clone();
            clone.questions = new ArrayList<>(this.questions);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
