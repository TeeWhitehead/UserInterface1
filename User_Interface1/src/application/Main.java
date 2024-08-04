package application;
	
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Menu Button
		MenuButton menu = new MenuButton("Menu");
		
		// Create Layout
		Pane root = new Pane(menu);
		Scene scene = new Scene(root, 500, 500);
		
		// Menu Items
		MenuItem date = new MenuItem("Date");
		MenuItem log_text = new MenuItem("Log Text");
		MenuItem color = new MenuItem("Color");
		MenuItem exit = new MenuItem("Exit");
		
		// Create Date and Time
		Date today = new Date();
		Text outputDate = new Text();
		
		// Button Actions
		date.setOnAction(event ->{
			// Display Date and Time
			outputDate.setText(today.toString());
			outputDate.relocate(100, 100);
			outputDate.setFont(new Font(20));
			root.getChildren().add(outputDate);
			
		});
		log_text.setOnAction(event ->{
			// Output log.txt
			File file = new File("log.txt");
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(outputDate);
			pw.close();
			
		});
		color.setOnAction(event ->{
			// Change green hue color
			List<String> greens = Arrays.asList("#00cc00", "#00e600", "#33ff33", "#008000", "#004d00");
			
			Random r = new Random();
			
			int randomItem = r.nextInt(greens.size());
			String randomElement = greens.get(randomItem);
			
			root.setStyle("-fx-background-color: " + randomElement  + ";");
			
		});
		exit.setOnAction(event ->{
			// Exit
			System.exit(0);
		});
  
		// Add Menu Items to Menu
		menu.getItems().add(date);
		menu.getItems().add(log_text);
		menu.getItems().add(color);
		menu.getItems().add(exit);
		
		// Set and display scene
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("User Interface");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
