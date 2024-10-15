import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
// this is the final page of the code the user sees 
public class complete extends returnBike {

		public static void show() { 

			Stage window = new Stage();
			window.setTitle("Recipt");
			window.setMinHeight(200);
			window.setMinWidth(500);
	// This makes sure that it dosent load , windows pop up from errors 
			window.initModality(Modality.APPLICATION_MODAL);

			Label label = new Label(); 
			Label costing = new Label("your total cost is "+ TheCost);
			Label balance = new Label("your current balance is :€"+getBalance());
			Button button = new Button("Close");
			button.setOnAction(e -> window.close());
			
			;
			VBox layout = new VBox(10); // Vertical box layout
			layout.getStylesheets().add(("Style.css"));
			layout.getChildren().addAll(label, button,costing,balance);
			layout.setAlignment(Pos.CENTER); // set vertical line into the centre

			// Display window and wait for it to be closed before returning
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.show();
		}

	}

