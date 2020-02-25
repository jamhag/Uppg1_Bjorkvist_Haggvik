package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*

ComboBox1, Data series:
Fås ur JSONObject

ComboBox2, Time series:
Tidsinterval
Fås ur Länken

ComboBox3, Symbol:
Företag
Hårdkodas

ComboBox4, Time interval:
Tidsinterval 1min, 5min, 15min...
Fås ur länken

ComboBox5, Output Size:
Full/Compact
Fås ur länken

*/
//https://www.geeksforgeeks.org/javafx-combobox-with-examples/

public class ShareAnalyser extends Application {
	
	public void start(Stage stage) {
		stage.setTitle("Share Analyser");
		
		TilePane r = new TilePane();
		
		Label description_label = new Label("This is a combo box");
		
		String TimeSeries[] = { "Time_Series_Intraday", "Time_Series_monthly", "Time_Series_weekly" };
		String DataSeries[] = {"1. open", "2. high", "3. low", "4. close", "5. volume"};
		
		ComboBox combo_box_time = new ComboBox(FXCollections.observableArrayList(TimeSeries));
		ComboBox combo_box_data = new ComboBox(FXCollections.observableArrayList(DataSeries));
		
		Label selected = new Label("default item selected");
		
		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				selected.setText(combo_box_time.getValue()+" selected");
			}
		};
		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				selected.setText(combo_box_data.getValue()+" selected");
			}
		};
		
		combo_box_time.setOnAction(event1);
		combo_box_data.setOnAction(event2);
		
		TilePane tile_pane = new TilePane(combo_box_time, selected);
		
		Scene scene = new Scene(tile_pane, 200, 200);
		
		stage.setScene(scene);
		
		stage.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}