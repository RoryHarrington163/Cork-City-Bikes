import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class Locations  {
	static int rentedBike;
	static String selectedLocation;
	static int count = 0;
	static int bikeRemain;
	static int bikesTaken;
	static boolean Adminalert = false;
	static String[][] myLocNum = new String[6][6];
 static String [] myLoc = {"Popes Quay","College Of Commerce","UCC","North Main St.","MTU"};
		static String record = " ";
public static void show(){
	bikeSpots();
	storage();
}
	//@Override
	public static void bikeSpots()  {
		
		int i;
	
		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("Locations.txt");
			BufferedReader textF = new BufferedReader(textFile);
		
			// while (record != null) {
			while (count < 5) {
			//	record = textF.readLine();
				myLoc[count] = record;
				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

		int count = 0;

		try {
			System.out.println("Loading bike locations from a file");
			FileReader textFile = new FileReader("Locations.txt");
			BufferedReader textF = new BufferedReader(textFile);

			// while (record != null) {

			while (count < 6) {
				record = textF.readLine();
				myLocNum[count][0] = record;
				 myLocNum[count][1] = "10";
				myLocNum[count][2] = "7";
				myLocNum[count][3] = "4";
				myLocNum[count][4] = "2";
			


				count += 1;
			}
		} catch (

		IOException e) {
			System.out.println("File Handle Exception");
		}

	}

	//@Override
	public static  void storage(){

		Button submit = new Button("Submit");
		TextField Rental = new TextField("0");
		Rental.setPromptText("Enter How many bikes to Rent?");
		ToggleGroup group = new ToggleGroup();

		
		RadioButton pq = new RadioButton(myLocNum[0][0] + " bikes remaining :" + myLocNum[1][1]);

		pq.setUserData(myLocNum[0][1]);
		
		pq.setStyle("-fx-base: lightgreen;");
		pq.setToggleGroup(group);

		RadioButton ccom = new RadioButton(myLocNum[1][0]+ " bikes remaining :" + myLocNum[1][1]);
		ccom.setUserData(myLocNum[1][0]);
		ccom.setStyle("-fx-base: lightblue;");
		ccom.setToggleGroup(group);

		RadioButton ucc = new RadioButton(myLocNum[2][0] + " bikes remaining :" + myLocNum[2][2]);
		ucc.setUserData(myLocNum[2][0]);
		ucc.setStyle("-fx-base: salmon;");
		ucc.setToggleGroup(group);
		
		RadioButton nms = new RadioButton(myLocNum[3][0] + " bikes remaining :" + myLocNum[3][3]);
		nms.setUserData(myLocNum[3][0]);
		nms.setStyle("-fx-base: yellow;");
		nms.setToggleGroup(group);
		
		
		RadioButton mtu = new RadioButton(myLocNum[4][0] + " bikes remaining :" + myLocNum[4][4]);
		mtu.setUserData(myLocNum[4][0]);
		mtu.setToggleGroup(group);
		
		
	pq.setOnAction(e->{
		if(pq.isSelected());
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(" apolgies Bike station unavailable ready for maintenence");
				alert.setContentText("unavialable bike");
				submit.setDisable(true);
				alert.showAndWait();
				
			 {

				}
					
			});	

		group.selectedToggleProperty().addListener((obserableValue, old_toggle, new_toggle) -> {
			if (group.getSelectedToggle() != null) {
				int rental = Integer.parseInt(Rental.getText());
				if(group.getSelectedToggle()!=null && rental > 0) {
				
				System.out.println("Index #" + group.getToggles().indexOf(new_toggle) + " selected!");
				//int rental = Integer.parseInt(Rental.getText()); //# of bikes to rent
				int x = group.getToggles().indexOf(new_toggle);  //index number of array
				int bikes = Integer.parseInt(myLocNum[x][x]); //# of bikes remaining
				System.out.println("this is my bikes print : "+ bikes );
				
				
				
			if (bikes<= 0) {
				Alert alert = new Alert (AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("error has occured");
			alert.setContentText("no more bikes");
			alert.showAndWait();
			}
			
			 if (rental > bikes) {
				Alert alert = new Alert (AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("error has occured");
				alert.setContentText("there isn't "+rental+" bikes to rent");
				alert.showAndWait();
			}
				bikeRemain = bikes - rental;
				//lowbike = myLocNum[x][x] = "3" || myLocNum[x][x] <= "2";
				myLocNum[x][1] = String.valueOf(bikeRemain);
				rentedBike = rental;
				bikesTaken = rental;
				
				// calculations part of locations 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				System.out.println(rental + " " + bikes + " " + myLocNum[x][x]);
				System.out.println("remaining bikes at " + group.getSelectedToggle().getUserData().toString() + " are "
						+ bikeRemain);
				selectedLocation= group.getSelectedToggle().getUserData().toString();
//				System.out.println(
//						"You have selected bike location:- " + group.getSelectedToggle().getUserData().toString());
				System.out.println("this is  location is "+ selectedLocation);
				
				
			}
			
			
			getUserrentedBikes();	
			}
		});
		

		
		ComboBox<String> bloc = new ComboBox<>();
		
		
submit.setOnAction(e->{
	showConfirmation();
});
		bloc.getItems().addAll("Popes quay","College Of Commerce","UCC","North Main St.");



		ArrayList<String> locate = new ArrayList<String>();
		//String record = " ";

		
		Stage window = new Stage();
		window.setTitle("bike locations");
		
		Button close = new Button("go back");
		close.setOnAction(e->window.close());
		// ComboBox<String> list = new ComboBox<>();
		VBox vbox = new VBox(20);
		vbox.getStylesheets().add(("Style.css"));
		vbox.setPadding(new Insets(30, 30, 30, 30));
		vbox.getChildren().addAll(Rental,pq, ccom, ucc,nms,mtu, submit,close);

		Scene scene = new Scene(vbox, 300, 400);
		window.setScene(scene);
		window.show();

	}
	
	// theses methods get the bike locations
	
	public static String getUserbikeLocation () {
		return selectedLocation;
		
	}
	public static int getUserrentedBikes () {
		System.out.println("the user has taken " + rentedBike + "bike ");
		return rentedBike;
	}
	public static void setUserrentedBikes() {
		getUserrentedBikes();
	}

	public  static void  Fixed() {
			Button addBikes = new  Button("to add fix bike ");
			Label showMessage = new Label("");
			
			Button confirmOpt = new Button(" click to confirm");
			Alert submitlbl = new Alert(AlertType.CONFIRMATION);
			submitlbl.setTitle("confirm rent bike(s)");
			submitlbl.setHeaderText("are you sure you wish to rent "+ bikesTaken +" at "+ selectedLocation);
			submitlbl.setContentText("to confirm to rent a bike press 'confirm' to cancel press 'cancel'");
			
			Optional<ButtonType> option = submitlbl.showAndWait();
			
			if(option.get() == null) {
				showMessage.setText("nothing selected");
			}else if(option.get()==ButtonType.OK) {
				showMessage.setText("bike rented");
				Bikes.show();
		 } else if (option.get() == ButtonType.CANCEL) {
	         showMessage.setText("Cancelled order");	
		 }else {
			 showMessage.setText("-");
				getUserrentedBikes();	
			}
		}
	public int returnbikes() {
			return bikesTaken;
		}
	public static void showConfirmation() {
		Label showMessage = new Label("");
	
		Button confirmOpt = new Button(" click to confirm");
		Alert submitlbl = new Alert(AlertType.CONFIRMATION);
		submitlbl.setTitle("confirm rent bike(s)");
		submitlbl.setHeaderText("are you sure you wish to rent  "+ bikesTaken +" bike(s) at "+ selectedLocation);
		submitlbl.setContentText("to confirm to rent a bike press 'confirm' to cancel press 'cancel'");
		
		Optional<ButtonType> option = submitlbl.showAndWait();
		
		if(option.get() == null) {
			showMessage.setText("nothing selected");
		}else if(option.get()==ButtonType.OK) {
			showMessage.setText("bike rented");
			Bikes.show();
	 } else if (option.get() == ButtonType.CANCEL) {
         showMessage.setText("Cancelled order");	
	 }else {
		 showMessage.setText("-");
			getUserrentedBikes();	
		}

		
		ComboBox<String> bloc = new ComboBox<>();
		Button submit = new Button("Submit");
		
		submit.setOnAction(e->{
			showConfirmation();
					});
		
		
		
		
		
		
	}

}





		