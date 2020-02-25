package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class FX extends Application{
	
	HttpsClient setup = new HttpsClient();
	JSONInterpreter convert = new JSONInterpreter();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Button query =  new Button("do query");
	Label notification = new Label();
	TextArea Data = new TextArea("Showing data for");
	
	@Override public void start(Stage stage) {
		stage.setTitle("Stock Analyser");
		Scene scene = new Scene(new Group(), 500, 500);
		
		ComboBox<String> DataSeries_CB = new ComboBox<String>();
		ComboBox<String> TimeSeries_CB = new ComboBox<String>();
		TimeSeries_CB.getItems().addAll("TIME_SERIES_INTRADAY",
										"TIME_SERIES_DAILY", 
										"TIME_SERIES_DAILY_ADJUSTED",
										"TIME_SERIES_WEEKLY", 
										"TIME_SERIES_WEEKLY_ADJUSTED",
										"TIME_SERIES_MONTHLY",
										"TIME_SERIES_MONTHLY_ADJUSTED");
		ComboBox<String> Symbol_CB = new ComboBox<String>();
		Symbol_CB.getItems().addAll("MSFT",
									"BA",
									"BABA");
		ComboBox<String> TimeInterval_CB = new ComboBox<String>();
		TimeInterval_CB.getItems().addAll(	"1MIN",
											"5MIN",
											"10MIN",
											"15MIN",
											"30MIN",
											"60MIN");
		ComboBox<String> OutputSize_CB = new ComboBox<String>();
		
	query.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			if (TimeSeries_CB.getValue() != null 
					&& Symbol_CB.getValue() != null 
					&& TimeInterval_CB.getValue() != null) {
				notification.setText("Download succesfull");
				convert.Converter(setup.Connect(TimeSeries_CB.getValue().toString(), Symbol_CB.getValue().toString(), TimeInterval_CB.getValue().toString()));
 			}
			else {
				notification.setText("Download failed");
			}
		}
	});
	
	GridPane grid = new GridPane();
	grid.setVgap(10);
	grid.setHgap(10);
	grid.setPadding(new Insets(5,5,5,5));
	
	//
	grid.add(new Label("Data Series"), 0, 0);
	grid.add(DataSeries_CB, 2, 0);
	grid.add(new Label("Time Series"), 0, 1);
	grid.add(TimeSeries_CB, 2, 1);
	grid.add(new Label("Symbol"), 0, 2);
	grid.add(Symbol_CB, 2, 2);
	grid.add(new Label("Time Interval"), 0, 3);
	grid.add(TimeInterval_CB, 2, 3);
	grid.add(new Label("Output Size"), 0, 4);
	grid.add(OutputSize_CB, 2, 4);
	
	grid.add(query, 2, 5);
	grid.add(notification, 3, 5);
	grid.add(Data, 0, 7, 5, 1);
	
	Group root = (Group)scene.getRoot();
	root.getChildren().add(grid);
	stage.setScene(scene);
	stage.show();
	
	}

}
