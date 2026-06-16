package util;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author u08471718170
 */
public class Conversor {
    
    public static Date TextoToDate(String textoData){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        try{
            Date minhaData = (Date) sdf.parse(textoData);      
            return new Date(minhaData.getTime());
        } catch (ParseException ex){
        return null;
    }
    }
    
    
}
