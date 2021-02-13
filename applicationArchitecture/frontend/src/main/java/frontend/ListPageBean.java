/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kohei
 */
@ViewScoped
public class ListPageBean implements Serializable {
    
    @PostConstruct
    public void getAll(){
        // To Do : Get all resultset
    }
    
    public void doSearch(){
        // To Do : Search resultset 
    }
    
    // Joinerデータの結果を返すメソッド
    
}
