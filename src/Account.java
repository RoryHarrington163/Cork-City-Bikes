import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javafx.application.*;


public class Account extends Application {

	Label fNameLbl = new Label("First Name");
	TextField fNameFld = new TextField();
	Label lNameLbl = new Label("Last Name");
	TextField lNameFld = new TextField();
	ComboBox<String> ageDay = new ComboBox<>();
	ComboBox<String> ageMon = new ComboBox<>();
	ComboBox<String> ageYear = new ComboBox<>();
	ComboBox<String> genderOpt = new ComboBox<>();
	ComboBox<String> County = new ComboBox<>();

	Label genderLbl = new Label("gender");
	Label agelbl = new Label("age");
	Button continueButt = new Button("continue");
	Label countyLbl = new Label("county");
	Label emailLbl = new Label("e-mail");
	Button backButt = new Button("go back");

	// continue if these values are all true 
	boolean validName = false;
	boolean validEmail = false;
	boolean validPhone = false;
	boolean selected = false;
	Boolean validbox = false;
	boolean validinput;
	int validated;
	//boolean valid

	public static final String String = null;
	Scene scene1, scene2, scene3, scene4;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button1 = new Button("sign up");
		Button button2 = new Button("sign in");
		//Button button5 = new Button("payment");
		//Button button6 = new Button("bikes");
//		Button button8 = new Button("rentbike");
		Button button4 = new Button("go back");
		Button button3 = new Button("go back");
		Button Help = new Button("Help/info");
		

		button2.setOnAction(e -> PinSIgnIN.show());
		button1.setOnAction(e -> primaryStage.setScene(scene4));
		//button5.setOnAction(e -> PaymentMethod.show());
		
		Help.setOnAction(e-> HelpScreen.show());
		button3.setOnAction(r -> primaryStage.setScene(scene1));
		button4.setOnAction(r -> primaryStage.setScene(scene4));

		GridPane gridpane = new GridPane();
		gridpane.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
		// gridpane.setGridLinesVisible(true);
		gridpane.getChildren().addAll(button3);
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(5);
		gridpane.setVgap(5); 
		ColumnConstraints column1 = new ColumnConstraints(100);
		ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
		column2.setHgrow(Priority.ALWAYS);

		gridpane.getColumnConstraints().addAll(column1, column2);
		scene4 = new Scene(gridpane);

		backButt.setOnAction(r -> primaryStage.setScene(scene1));

		Label phoneLbl = new Label("Phone number");
		TextField phoneFld = new TextField();
		Label PinNewLbl = new Label("create pin number");
		Label PincreateLbl = new Label("enter pin number");
		
//
//		TextField pinFld = new TextField();
//		TextField pinCFld = new TextField();
		TextField emailFld = new TextField();
		Label eirCodeLbl = new Label("eir code");
		TextField eirCodeFld = new TextField();
		Label consentLbl = new Label("Terms&conditions pay €150");
		Button btnEmail = new Button("accept Email");
		CheckBox confirmBox = new CheckBox("confirm");
		ComboBox<String> option = new ComboBox<>();
		Label optionlbl = new Label("select a pass");
		ComboBox<String> age = new ComboBox<>();
		Button Checknm = new Button("Validate");
		Button b1 = new Button("Submit");
		
		genderOpt.getItems().addAll("male","female","other");
		genderOpt.setValue("other");
		ageDay.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
		ageDay.setValue("1");

		ageMon.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December");
		ageMon.setValue("January");

		ageYear.getItems().addAll("2007", "2006", "2005", "2004", "2003", "2002", "2001", "2002", "2001", "2000",
				"1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987",
				"1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
				"1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961",
				"1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950");
		ageYear.setValue("2007");
		
		
		option.getItems().addAll("3-day pass","Annual");
		County.getItems().addAll("antrim", "armagh", "carlow", "cavan", "clare", "cork", "derry", "donegal", "down",
				"dublin", "fermanagh", "galway", "kerry", "kildare", "kilkenny", "laois", "leitrim", "limerick",
				"longford", "louth", "mayo", "meath", "monaghan", "offaly", "roscommon", "sligo", "tipperary", "tyrone",
				"waterford", "westmeath", "wexford", "wicklow");
		County.setValue("Cork");
		System.out.println(age.getValue());

		age.setPromptText("Select age");
		age.setEditable(true);
		age.setVisibleRowCount(6);
		age.setOnAction(e -> System.out.println("This was printed from a button click " + age.getValue()));

		age.setOnAction(e -> System.out.println("Combo box creates its own action " + age.getValue()));

		GridPane.setHalignment(backButt, HPos.RIGHT);
		gridpane.add(backButt, 0, 19);
		// First name label
		GridPane.setHalignment(fNameLbl, HPos.RIGHT);
		gridpane.add(fNameLbl, 0, 0);

		// Last name label
		GridPane.setHalignment(lNameLbl, HPos.RIGHT);
		gridpane.add(lNameLbl, 0, 1);

		// First name field
		GridPane.setHalignment(fNameFld, HPos.LEFT);
		gridpane.add(fNameFld, 1, 0);

		// Last name field
		GridPane.setHalignment(lNameFld, HPos.LEFT);
		gridpane.add(lNameFld, 1, 1);
		gridpane.add(Checknm, 1, 2);
		
		Checknm.setOnAction(e-> {
		if(!fNameFld.getText().matches("[a-zA-Z\\s']+")&& !lNameFld.getText().matches("[a-zA-Z\\s']+")) {
			Alert alert = new Alert (AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("error has occured");
			alert.setContentText("Name must only contain letters");
			fNameFld.setStyle("-fx-border-color: red; -fx-padding: 5px;");
			lNameFld.setStyle("-fx-border-color: red; -fx-padding: 5px;");
			alert.showAndWait();
			
		}else if(fNameFld.getText().matches("[a-zA-Z\\s']+")&& lNameFld.getText().matches("[a-zA-Z\\s']+")) {
			
			fNameFld.setStyle("-fx-border-color: green; -fx-padding: 5px;");
			lNameFld.setStyle("-fx-border-color: green; -fx-padding: 5px;");
			 validName = true;
			System.out.println("Correct name");
		}
		
		
			
		});
		
	
		// continue  button
		GridPane.setHalignment(continueButt, HPos.RIGHT);
		gridpane.add(continueButt, 1, 13);
		
		
		// annual pass and 3 day pass
		GridPane.setHalignment(option, HPos.RIGHT);
		gridpane.add(option, 4, 0);
		GridPane.setHalignment(optionlbl, HPos.RIGHT);
		gridpane.add(optionlbl, 3, 0);
		
		
		
		
		// age field
		GridPane.setHalignment(agelbl, HPos.RIGHT);
		gridpane.add(agelbl, 0, 3);
		GridPane.setHalignment(ageDay, HPos.LEFT);
		gridpane.add(ageDay, 1, 3);
		GridPane.setHalignment(ageMon, HPos.LEFT);
		gridpane.add(ageMon, 2, 3);
		GridPane.setHalignment(ageYear, HPos.RIGHT);
		gridpane.add(ageYear, 3, 3);

		// gender drop down
		GridPane.setHalignment(genderOpt, HPos.LEFT);
		gridpane.add(genderOpt, 1, 4);

		// gender label
		GridPane.setHalignment(genderLbl, HPos.RIGHT);
		gridpane.add(genderLbl, 0, 4);

		// county drop down
		GridPane.setHalignment(County, HPos.LEFT);
		gridpane.add(County, 1, 5);
		GridPane.setHalignment(countyLbl, HPos.RIGHT);
		gridpane.add(countyLbl, 0, 5);

		// EirCode label
		GridPane.setHalignment(eirCodeLbl, HPos.RIGHT);
		gridpane.add(eirCodeLbl, 0, 7);
		GridPane.setHalignment(eirCodeFld, HPos.RIGHT);
		gridpane.add(eirCodeFld, 1, 7);

		// email label and text
		GridPane.setHalignment(emailLbl, HPos.RIGHT);
		gridpane.add(emailLbl, 0, 6);
		GridPane.setHalignment(emailFld, HPos.RIGHT);
		gridpane.add(emailFld, 1, 6);
		gridpane.add(btnEmail, 2, 6);
	
		
		btnEmail.setOnAction(e -> {
			
			if (!emailFld.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
				
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("error has occured");
				alert.setContentText("invalid email");
				alert.showAndWait();
				System.out.println("You must enter a correct email address");
				emailFld.setStyle("-fx-border-color: red; -fx-padding: 5px;");				
			} 
			
			
			else
				emailFld.setStyle("-fx-border-color: green; -fx-padding: 5px;");
				System.out.println(" correct email address");
				//continueButt.setDisable(false);
				validEmail = true;
		});



		if (validEmail && validName)  {
			
		}
		
		
		// T&t label and checkbox
		GridPane.setHalignment(consentLbl, HPos.LEFT);
		gridpane.add(consentLbl, 0, 8);
		GridPane.setHalignment(confirmBox, HPos.LEFT);
		gridpane.add(confirmBox, 1, 8);

		// pin and created pin labels
		
		
		// payment options

		VBox layout1 = new VBox(10);
		layout1.getStylesheets().add(("Style.css"));
		Label label1 = new Label("Sign up");
		layout1.getChildren().addAll( button1, button2, button3,Help);
		scene1 = new Scene(layout1, 300, 300);

		// sign up button to page 3
		VBox layout2 = new VBox(39);
		layout2.getStylesheets().add(("Style.css"));
		layout2.getChildren().addAll(button4);
		scene2 = new Scene(layout2, 500, 500);

		// sign in button
		GridPane layout3 = new GridPane();
		layout2.getStylesheets().add(("Style.css"));
		layout3.getChildren().addAll(button3);

		scene3 = new Scene(layout3, 500, 500);
		// Display scene 1 at first
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Sign In/Sign Up ");
		primaryStage.show();
	
	int i= 0;
	int[][] PinNum = new int[3][2];{

		PinNum[i][0] = 1234;
		PinNum[i][0] = 1111;
		
		System.out.println("Pin " + i+ " " + PinNum[i][0]);
		System.out.println("Top up " + PinNum[i][1]);
		
	

	Button createPin = new Button("create Pin");
	
	Button signIn = new Button();
	TextField Pin = new TextField();
	TextField Topup = new TextField();
	Pin.setPromptText("Please enter Pin");
	Topup.setPromptText("plese enter amount in whole");
	TextField nPin = new TextField();
	Button check = new Button("Check Pin");
	
	check.setOnAction(e -> {
		
		for ( int row = 0; i < PinNum.length; row++) {
			// Pin variable is the text field turned into integer
			int Pnum = Integer.parseInt(Pin.getText());
			 String top = (Topup.getText());
			System.out.println(PinNum[i][0]);
			System.out.println(Pnum);
			if (Pnum == PinNum[i][0]) {
				int topup = PinNum[i][1];
			
				 System.out.println("we have a match " + Pnum);
				break;
			}
			System.out.println("We do not have a match");
			break;
		}
	});

		createPin.setOnAction(e -> {
		int newtopup = 25;
		int npin = Integer.parseInt(nPin.getText());
		//IF THE PIN IS 1234 OR 1111 IT WILL PROMT USER TO RE ENTER 
		if(npin == 1234 || npin == 1111 || npin == 2222) {
			Alert alert = new Alert (AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("error has occured");
			alert.setContentText("account already in use");
			alert.showAndWait();
		}
		System.out.println(" you have updated your  pin ");
		PinNum[i][0] = npin;
		System.out.println("New Pin is " + i + " " + PinNum[i][0]);
		PinNum[i][1] = newtopup;
		
		});
		continueButt.setOnAction(e->{
			if (validEmail == true && validName == true) {
				PaymentMethod.show();
			}
			else {
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("error has occured");
				alert.setContentText("you must look at your validations");
				alert.showAndWait();
			}
			
		});
		
		
		nPin.setPromptText("Please enter new Pin");
		
			GridPane.setHalignment(nPin, HPos.LEFT);
			gridpane.add(nPin, 1, 9);
			GridPane.setHalignment(nPin, HPos.LEFT);
			gridpane.add(createPin, 2, 9);
			GridPane.setHalignment(check, HPos.LEFT);
			gridpane.add(check, 2, 10);
			GridPane.setHalignment(PinNewLbl, HPos.RIGHT);
			gridpane.add(PinNewLbl, 0, 9);
			GridPane.setHalignment(PincreateLbl, HPos.RIGHT);
			gridpane.add(PincreateLbl, 0, 10);
			GridPane.setHalignment(Pin, HPos.LEFT);
			gridpane.add(Pin, 1, 10);
	}
	
	}
}
