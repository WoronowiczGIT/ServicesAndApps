package myTester.controllers;

import myTester.views.MainView;
import myTester.TestRunner;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

import javax.naming.NameNotFoundException;
import java.io.File;
import java.io.IOException;

public class MainViewController {
    private static MainView view;
    private static FileChooser chooser;
    private File selectedFile;
    private TestRunner runner;

    public MainViewController(MainView view, TestRunner runner){
         this.view= view;
         this.runner = runner;
         chooser = new FileChooser();
         view.getSelectBtn().setOnAction(selectFile);
         view.getTestBtn().setOnAction(startTest);
    }

    private EventHandler selectFile = new EventHandler() {
        @Override
        public void handle(Event event) {
              selectedFile = chooser.showOpenDialog(view.getWindow());
              if(selectedFile != null){
                  view.getSelectedFileLbl().setText(selectedFile.getAbsolutePath());
              }
        }
    };

    private EventHandler startTest = new EventHandler() {
        @Override
        public void handle(Event event){
            if(selectedFile != null){
                try {
                    runner.run(selectedFile);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}
