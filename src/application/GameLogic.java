package application;

import java.util.*;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameLogic {

    CorrectSound correctSound = new CorrectSound();
    IncorrectSound incorrectSound = new IncorrectSound();
    GridPaneOperator gridPaneOperator = new GridPaneOperator();
    
    // check if the player correctly answer which picture is under the current lid
    public boolean check(GridPane myGridPane, Rectangle rectangle, ChoiceBox<String> choiceBox2) {

        String answer = choiceBox2.getValue();
        int targetRow = GridPane.getRowIndex(rectangle);
        int targetColumn = GridPane.getColumnIndex(rectangle);
        boolean result = false;

        System.out.println(answer);

        for (Node node : myGridPane.getChildren()) {
            if (node instanceof ImageView) {
                if (GridPane.getColumnIndex(node) == targetColumn
                        && GridPane.getRowIndex(node) == targetRow
                        && answer.equals(node.getId())) {

                    result = true;
                    node.setVisible(false);
                    node.setDisable(true);
                }
            }
        }
        return result;
    }
    
    // end game. make all lids fadeout when there is only 4 picture left
    public void endGame(GridPane myGridPane) {
        for (Node node : myGridPane.getChildren()) {
            if (node instanceof Rectangle) {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), node);
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0);
                fadeOut.play();
            }
        }
    }
    
    // show the 1st, 2nd, 3rd place
    public void winner(int score1, int score2, int score3, int score4, Label first, Label second, Label third) {
        HashMap<Integer, String> winner = new HashMap<>();
        winner.put(score1, "Oggy");
        winner.put(score2, "Jack");
        winner.put(score3, "Olivia");
        winner.put(score4, "Bob");
    
        // Create a TreeSet with a custom comparator to sort by keys
        TreeSet<Map.Entry<Integer, String>> sortedEntries = new TreeSet<>(
                Comparator.<Map.Entry<Integer, String>>comparingInt(Map.Entry::getKey).reversed()
        );
    
        // Add all entries from the HashMap to the TreeSet
        sortedEntries.addAll(winner.entrySet());
    
        // Retrieve the entries based on their position in the set
        Iterator<Map.Entry<Integer, String>> iterator = sortedEntries.iterator();
    
        if (iterator.hasNext()) {
            Map.Entry<Integer, String> firstPlace = iterator.next();
            first.setText(firstPlace.getValue());
        }
    
        if (iterator.hasNext()) {
            Map.Entry<Integer, String> secondPlace = iterator.next();
            second.setText(secondPlace.getValue());
        }
    
        if (iterator.hasNext()) {
            Map.Entry<Integer, String> thirdPlace = iterator.next();
    
            if (thirdPlace.getKey() != 0) {
                third.setText(thirdPlace.getValue());
            } else {
                third.setText(null);
            }
        } else {
            // Handle the case where there are less than three entries in the set
            third.setText(null);
        }
    }
    
}
