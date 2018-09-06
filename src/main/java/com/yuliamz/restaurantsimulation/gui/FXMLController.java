package com.yuliamz.restaurantsimulation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.RestaurantSimulation;
import logic.entity.Dish;
import logic.entity.DishStat;
import org.controlsfx.control.RangeSlider;

public class FXMLController implements Initializable {
    
    private ObservableList<DishStat> data;
    
    @FXML
    private RangeSlider dinerRangeSlider,workDayRangeSlider;
    @FXML
    private Label minDinerLabel,maxDinerLabel,minWorkDayLabel,maxWorkDayLabel;
    @FXML
    private Spinner<Integer> simulationTimeSpinner;
    @FXML
    private TableView<DishStat> resultsTable;
        @FXML
    private TableColumn<DishStat, Dish> dishColumn;

    @FXML
    private TableColumn<DishStat, Integer> sellsColumn,rankedColumn;

    @FXML
    private TableColumn<DishStat, Double> rankColumn;
    
    @FXML
    private void startSimulation(){
        data.clear();
        RestaurantSimulation rs = new RestaurantSimulation((int)dinerRangeSlider.getHighValue(),
                (int)dinerRangeSlider.getLowValue(),
                (int)workDayRangeSlider.getHighValue(),
                (int)workDayRangeSlider.getLowValue(),
                simulationTimeSpinner.getValue());
        rs.startSimulation();
        data.add(rs.getPlato1());
        data.add(rs.getPlato2());
        data.add(rs.getPlato3());
        data.add(rs.getPlato4());
        rs.printStats();
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        dinerRangeSlider.setMax(200.0);
        dinerRangeSlider.setMin(0.0);
        dinerRangeSlider.setLowValue(73.0);
        dinerRangeSlider.setHighValue(103.0);
        
        workDayRangeSlider.setMax(24);
        workDayRangeSlider.setMin(0);
        workDayRangeSlider.setLowValue(10);
        workDayRangeSlider.setHighValue(12);
        
        dinerRangeSlider.lowValueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            minDinerLabel.setText(""+newValue.intValue());
        });
        dinerRangeSlider.highValueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            maxDinerLabel.setText(""+newValue.intValue());
        });
        workDayRangeSlider.lowValueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            minWorkDayLabel.setText(""+newValue.intValue());
        });
        workDayRangeSlider.highValueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            maxWorkDayLabel.setText(""+newValue.intValue());
        });
        
        
        
        dishColumn.setCellValueFactory(new PropertyValueFactory<>("dish"));
        sellsColumn.setCellValueFactory(new PropertyValueFactory<>("totalSells"));
        rankedColumn.setCellValueFactory(new PropertyValueFactory<>("rankedSells"));
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        data = FXCollections.observableArrayList();
        resultsTable.setItems(data);
        simulationTimeSpinner.valueFactoryProperty().getValue().setValue(100);
    }    
}
