package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;
	// Labels
	@FXML

	private Label lblMonthToSave;
	@FXML
	private Label lblWhatUNeedToSave;
	// TextField
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		lblMonthToSave.setText("");
		lblWhatUNeedToSave.setText("");
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		// TODO: Clear all the text inputs
	}

	@FXML

	public void btnCalculate(ActionEvent event) {

		try
		{
			Integer.parseInt(this.txtYearsToWork.getText());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Data Type Wrong");
			alert.setHeaderText("Data Type Wrong");
			alert.setContentText("Please Provade an integer for \"Years To Work\".");
			alert.showAndWait();
		}
		try
		{
			Double.parseDouble(this.txtAnnualReturnWorking.getText());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Data Type Wrong");
			alert.setHeaderText("Data Type Wrong");
			alert.setContentText("Please Provade a Double for the first \"Annual Return\".");
			alert.showAndWait();
		}
		try
		{
			Integer.parseInt(this.txtYearsRetired.getText());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Data Type Wrong");
			alert.setHeaderText("Data Type Wrong");
			alert.setContentText("Please Provade an integer for \"Years Retired\".");
			alert.showAndWait();
		}
		try
		{
			Double.parseDouble(this.txtAnnualReturnRetired.getText());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Data Type Wrong");
			alert.setHeaderText("Data Type Wrong");
			alert.setContentText("Please Provade a double for the second \"Annual Return\".");
			alert.showAndWait();
		}
		try
		{
			Double.parseDouble(this.txtRequiredIncome.getText());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Data Type Wrong");
			alert.setHeaderText("Data Type Wrong");
			alert.setContentText("Please Provade a double for the second \"Required Income\".");
			alert.showAndWait();
		}
		try
		{
			Double.parseDouble(this.txtMonthlySSI.getText());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Data Type Wrong");
			alert.setHeaderText("Data Type Wrong");
			alert.setContentText("Please Provade a double for the second \"Monthly SSI\".");
			alert.showAndWait();
		}
		if (Double.parseDouble(this.txtAnnualReturnRetired.getText()) < 0 ||
				Double.parseDouble(this.txtAnnualReturnRetired.getText()) > 0.03)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Out Of Range");
			alert.setHeaderText("Out Of Range");
			alert.setContentText("Please use a range of 0-3% for annual return when in payback mode.");
			alert.showAndWait();
		}
		else if (Double.parseDouble(this.txtAnnualReturnWorking.getText()) < 0 ||
				Double.parseDouble(this.txtAnnualReturnWorking.getText()) > 0.2)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Out Of Range");
			alert.setHeaderText("Out Of Range");
			alert.setContentText("Please use a range of 0-20% for annual return when in investment mode.");
			alert.showAndWait();
		}
		else
		{
			Retirement r = new Retirement(Integer.parseInt(this.txtYearsToWork.getText()),
					Double.parseDouble(this.txtAnnualReturnWorking.getText()),
					Integer.parseInt(this.txtYearsRetired.getText()),
					Double.parseDouble(this.txtAnnualReturnRetired.getText()),
					Double.parseDouble(this.txtRequiredIncome.getText()),
					Double.parseDouble(this.txtMonthlySSI.getText()));
					Double pv = r.TotalAmountSaved();			
					Double pmt = r.AmountToSave();
			this.lblWhatUNeedToSave.setText(String.format("%.2f", pv));
			this.lblMonthToSave.setText(String.format("%.2f", pmt));
			// TODO: Call AmountToSave and TotalAmountSaved and populate
		}
	}
}
