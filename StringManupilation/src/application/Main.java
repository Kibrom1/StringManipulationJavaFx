package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("String Manipulation");
			GridPane grid = new GridPane();

			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setVgap(10);
			grid.setHgap(10);
			Button btnCount = new Button("Count Letters");
			btnCount.setPrefWidth(120);
			grid.add(btnCount, 0, 0, 1, 3);

			Button btnReverse = new Button("Reverse");
			btnReverse.setPrefWidth(120);
			grid.add(btnReverse, 0, 3, 1, 3);

			Button btnRemoveDuplicate = new Button("Remove Duplicate");
			btnRemoveDuplicate.setPrefWidth(120);
			grid.add(btnRemoveDuplicate, 0, 6, 1, 3);

			grid.setAlignment(Pos.CENTER);

			TextField txtInput = new TextField();
			txtInput.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
			grid.add(txtInput, 1, 2);
			Label lblInput = new Label("Input");
			grid.add(lblInput, 1, 1);

			Label lblOutput = new Label("output");
			grid.add(lblOutput, 1, 3);
			TextField txtOutput = new TextField();
			txtOutput.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
			grid.add(txtOutput, 1, 4);

			btnCount.setOnAction(e -> {
				int input = txtInput.getText().length();
				txtOutput.setText("" + input);
			});

			btnReverse.setOnAction(e -> {
				String input = txtInput.getText();
				String output = "";
				for (int i = input.length() - 1; i >= 0; i--) {
					output += input.substring(i, i + 1);
				}
				txtOutput.setText(output);
			});

			btnRemoveDuplicate.setOnAction(e -> {
				String input = txtInput.getText();
				String output = "";
				for (int i = 0; i < input.length(); i++) {
					if (!output.contains(input.substring(i, i + 1)))
						output += input.substring(i, i + 1);
				}
				txtOutput.setText(output);
			});
			Scene scene = new Scene(grid, 400, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
