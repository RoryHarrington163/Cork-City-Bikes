import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserTopup extends PaymentMethod {
	
	static Button next = new Button("continue");
	
	
	public static void show() {
		Stage window = new Stage();
	
		window.setTitle("Topup page ");
		TextField Topup = new TextField();
		Topup.setPromptText("enter a whole number ");
		Button addTopup = new Button("add top up o your current account");
		
		next.setDisable(true);
		Label Topuplbl = new Label("?");
		addTopup.setOnAction(e -> {
			int[] toppedUp = new int[3];	
			int i = 0;
			toppedUp[i]=10;
			for ( int row = 0; i < toppedUp.length; row++) {
				// Pin variable is the text field turned into 
				int userTopup = Integer.parseInt(Topup.getText());
				 String top = (Topup.getText());
				System.out.println(toppedUp[i]);
				System.out.println("your topup is "+ userTopup);
				currentTopup = userTopup;
				Topuplbl.setText("Current balance is : €"+userTopup);
				next.setDisable(false);
				
				if (userTopup < 10) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("error has occured");
					alert.setContentText("topup must be €10 or more");
					alert.showAndWait();
				}
				break;
				}
			
			
			
			});
		next.setOnAction(e->{
		Bikes.show();
	
		});
			
		
			
			// Display window and wait for it to be closed before returning
		
		
		
		VBox layout = new VBox(30); // Vertical box layout
		layout.getStylesheets().add(("Style.css"));
		layout.getChildren().addAll(Topup,addTopup,Topuplbl,next);
		System.out.println(" the out put is ");
		layout.setAlignment(Pos.CENTER); // set vertical line into the centre
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
}
	public static int returnUserBalance () {
		return currentTopup;
	}
}
