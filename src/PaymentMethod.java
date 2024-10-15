import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.application.*;

public class PaymentMethod  {
	static int currentTopup;
	static boolean validCardNumber = false;
	static boolean securityValid = false;
	static boolean validtopup = false;
	
	public static void show() {

		Stage window = new Stage();
		//	window.setTitle(title);
		window.setMinHeight(200);
		window.setMinWidth(500);
		window .setTitle("Payment method");
		// This makes sure that it dosent load , windows pop up from errors 
		window.initModality(Modality.APPLICATION_MODAL);
		Button button = new Button("go back");
		button.setOnAction(e -> window.close());
		GridPane gridpane = new GridPane();
		gridpane.getStylesheets().add(("Style.css"));
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5); 
		ColumnConstraints column1 = new ColumnConstraints(100);
		ColumnConstraints column2 = new ColumnConstraints(50, 250, 300);
		column2.setHgrow(Priority.ALWAYS);
		
		
		ComboBox<String> expyDrp1 = new ComboBox<>();
		ComboBox<String> expyDrp2 = new ComboBox<>();
		
		Button checkNumber = new Button("validate credit card number ");
		TextField securityFld = new TextField("0");
		
		TextField creditFld = new TextField("0");
		checkNumber.setOnAction(e->{
			if (!(creditFld.getText().matches("^4[0-9]{12}(?:[0-9]{3})?$"))) {
			Alert alert = new Alert (AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("error has occured");
			alert.setContentText("must start with a 4 and be at 12 characters long");
			alert.showAndWait();
			creditFld.setStyle("-fx-border-color: red; -fx-padding: 5px;");
			
		}
			else {
				creditFld.setStyle("-fx-border-color: green; -fx-padding: 5px;");
				validCardNumber=true;
				
			}
		});
		Button nextPage = new Button("continue");
		
		
		
		Label expylbl = new Label("enter expiry date");
		Label creditlbl = new Label("enter credit card details");
		
		Label securitylbl = new Label("enter 3 digit code");
		TextField Topup = new TextField("0");
				
		
		
		int securityNum = Integer.parseInt(securityFld.getText());
		
		Button checkdigits = new Button("validate  digits ");
		
		//checks if valid 
		checkdigits.setOnAction(e->{
			if (!securityFld.getText().matches("[0-9]{3}")) {
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("error has occured");
				alert.setContentText("invalid 3 digit number");
				securityFld.setStyle("-fx-border-color: red; -fx-padding: 5px;");
				alert.showAndWait();
			
			
			}
		
			else  {
			
				securityFld.setStyle("-fx-border-color: green; -fx-padding: 5px;");
				securityValid = true;
			}
			
			
			
		
		});
		
		nextPage.setOnAction(e->{
			if (securityValid && validCardNumber) {
			nextPage.setDisable(false);
			UserTopup.show();
		}
			else {
			Alert alert = new Alert (AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("error has occured");
			alert.setContentText("check numbers");
			securityFld.setStyle("-fx-border-color: red; -fx-padding: 5px;");
			alert.showAndWait();
				
			}
			
		});
		
		expyDrp1.getItems().addAll("22", "23", "24", "25", "26", "27");
		expyDrp1.setPromptText("year");
		expyDrp2.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
		expyDrp2.setPromptText("mon");
		
		
		
		

		
		
	
		
		Topup.setPromptText("only in integer numbers");
		Button addTopup = new Button("add to current account");
		GridPane.setHalignment(button, HPos.LEFT);
		gridpane.add(button, 1, 5);
		//gridpane.add(label, 0, 5);	
		
		//credit card number 
		GridPane.setHalignment(creditFld, HPos.LEFT);
		gridpane.add(creditlbl, 0, 1);
		gridpane.add(creditFld, 1, 1);
		gridpane.add(checkNumber, 2, 1);
		
		//expiry date
		GridPane.setHalignment(expyDrp1, HPos.LEFT);
		gridpane.add(expylbl, 0, 2);
		gridpane.add(expyDrp1, 1, 2);
		gridpane.add(expyDrp2, 2, 2);
		
		// security num
		GridPane.setHalignment(securityFld, HPos.LEFT);
		gridpane.add(securityFld, 1, 3);
		gridpane.add(securitylbl,0,3);
		gridpane.add(checkdigits,2,3);
		
		// top up 
		GridPane.setHalignment(Topup, HPos.LEFT);
		gridpane.add(Topup, 0, 4);
		gridpane.add(addTopup, 1,4);
		
		GridPane.setHalignment(nextPage, HPos.LEFT);
		
		gridpane.add(nextPage, 2,5);
			
			
			
		
		
		
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
			break;
			}
		
		
		
		});
		
		
		// Display window and wait for it to be closed before returning
		Scene scene = new Scene(gridpane);
		window.setScene(scene);
		window.show();
		
	}
	
	public static int getuserTopUp() {
//		System.out.println("your top up is " + currentTopup);
			return currentTopup;
			
		}
	
//		return currentTopup;
	
	
	

	
}

	

