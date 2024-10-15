import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelpScreen   {
	public static void show() {

		
		Stage window = new Stage();
		VBox vbox = new VBox(30);
		vbox.getStylesheets().add(("Style.css"));
		window.setTitle("Help/Info");

	
//shows the user what there purchasing and info
	
		

	Button close = new Button("Close");
	close.setOnAction(e->window.close());
	
		Label Showpricing  = new Label("The first 30 mins is free /n up to 1 hour is 50 cent/nUp to 2 hours is €1.50\nUp to 3 hours is €6.50\n after that it's €2.00 per half hour ");
		Label ShowUseriNFO = new Label("You must top up by €10 or more\n Your pin must be a 4 digits\n A Deposit of a hundred euro is required in the payment\nTHIS MACHINE ONLY ACCEPTS WHOLE NUMBERS  ANY THING ELSE WILL BE TAKEN FROM YOUR ACCOUNT");
		
		

		vbox.setPadding(new Insets(30, 30, 30, 30));
		vbox.getChildren().addAll(close,Showpricing,ShowUseriNFO);

		Scene scene = new Scene(vbox, 900, 400);
		window.setScene(scene);
		window.show();
		}
	}


