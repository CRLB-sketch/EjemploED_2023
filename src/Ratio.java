/**
 * <h1> Hoja de Trabajo 01 </h1>
 * <h2> Ratio/Radio (clase tipo "Modelo") </h2>
 * 
 * Controladores de Radios
 * 
 * Esta clase representará a una radio normal.
 * 
 * <p> Algoritmos Estructuras de datos - Universidad del Valle de Guatemala </p>
 * 
 * Creado por:
 * @author Cristian Laynez
 * @version 1.0
 * @since 2021-Enero-16
 * 
 * ESTA CLASE ESTA POR FINES DIDACTICOS Y PARA DAR EJEMPLOS
 **/    

 import java.util.ArrayList;

 public class Ratio implements IRatio{
     
     // --> Atributos                
     protected final static int LIMIT_BUTTONS = 12;
     protected double[] favorites;
     protected boolean on; // true: encendido, false: apagado
     protected String frecuence; // AM, FM
     private ArrayList<Double> stationsFM;
     private ArrayList<Double> stationsAM;
         
     // --> Contructor
     public Ratio(){
         favorites = new double[LIMIT_BUTTONS];
         on = true;
         frecuence = "AM";
         stationsFM = new ArrayList<>();
         stationsAM = new ArrayList<>();
         
         addStationsFM();
         addStationsAM();
     }
     
     private void addStationsFM(){
         stationsFM.add(88.1);
         stationsFM.add(88.9);
         stationsFM.add(89.3);
         stationsFM.add(90.1);
         stationsFM.add(90.5);
         stationsFM.add(90.9);
         stationsFM.add(91.3);
         stationsFM.add(92.5);
         stationsFM.add(92.9);
         stationsFM.add(94.9);
         stationsFM.add(95.3);
         stationsFM.add(96.5);
         stationsFM.add(97.3);
         stationsFM.add(103.3);
         stationsFM.add(104.9);
     }
     
     private void addStationsAM(){
         stationsAM.add(580.0);
         stationsAM.add(700.0);
         stationsAM.add(730.0);
         stationsAM.add(760.0);
         stationsAM.add(820.0);
         stationsAM.add(880.0);
         stationsAM.add(910.0);
         stationsAM.add(940.0);
         stationsAM.add(1030.0);
         stationsAM.add(1210.0);
         stationsAM.add(1330.0);
         stationsAM.add(1360.0);
         stationsAM.add(1150.0);
         stationsAM.add(1540.0);
         stationsAM.add(1570.0);
     }
                 
     
     /** 
      * Getter de Encender
      * 
      * @return boolean
      */
     // --> Propiedades
     public boolean getOn(){
         return on;
     }
 
     
     /** 
      * Encender y apagar:
      * ...
      * 
      * @return String : Informacion de la radio
      */
     // --> Métodos            
     public String turnOnRatio(){        
                 
         if(!on){ // Si esta apagado
             on = true;
             return "Encendiendo...";
         }
         else{
             return "Hey! Ya esta encendido";
         }        
         
     }
     
     
     /** 
      * @return String
      */
     public String turnOffRatio(){
                
         if(on){ // Si esta encendido
             on = false;
             return "Apagando...";
         }
         else{ // Esta apagado
             return "Hey! Esta apagado.";
         }      
         
     }
                
     
     /** 
      * @return String
      */
     public String checkFavs(){
         String allFavs = "";
         
         int count = 0;
         for(double i: favorites){
             count += 1;
             allFavs += "-> Boton [" + count + "] Emisora #" + i + "\n";
         }
         
                 
         return allFavs;
     }
     
     
     /** 
      * @param number
      * @return String
      */
     public String moveDial(int number){
         String info = "";
                         
         if(frecuence.equals("AM")){
            double temp = stationsAM.get(number);
            info += "Ahora estas en " + temp + " de AM";
         }
         else{ // Si es FM
             double temp = stationsFM.get(number);
             info += "Ahora estas en " + temp + " de FM";
         }
                 
         return info;
     }
     
     
     /** 
      * @return String
      */
     public String changeFrecuence(){
         String info = "";
         
         if(frecuence.equals("AM")){
             frecuence = "FM";
             info += "Se cambio de AM a FM";
         }
         else{ // Si es FM
             frecuence = "AM";
             info += "Se cambio de FM a AM";
         }
                 
         return info;
     }
         
     
     /** 
      * @param the_dial
      * @return double
      */
     public double readCurrentState(int the_dial){
         double temp = 0;
         
         if(frecuence.equals("AM")){
             temp = stationsAM.get(the_dial);
         }
         else{ // Si es FM
             temp = stationsFM.get(the_dial);
         }
 
         return temp;
     }
     
     
     /** 
      * @param the_dial
      * @return double
      */
     public double obtainFav(int the_dial){
         double temp = 0;
         
         the_dial -= 1;
         temp = favorites[the_dial];
         
         return temp;
     }
 
     
     /** 
      * @param the_button_selected
      * @param fav_station
      * @return String
      */
     public String addFavorite(int the_button_selected, double fav_station){
         String information = "";
         
         // Revisar si es válida la emosora o no
         if(fav_station >= 87 && fav_station <= 1600){
             if(the_button_selected >= 1 && the_button_selected <= 12){
             the_button_selected -= 1;
             favorites[the_button_selected] = fav_station;
             information += "Succes";
             }            
             else{
                 information += "Invalid Button";
             }
         }
         else{
             information += "Invalid Station";
         }
                 
         return information;
     }
     
     
     /** 
      * @param state
      * @return String
      */
     public String obtainState(double state){
         String information = "";
         
         if(frecuence.equals("AM")){
             information += "Seleccionaste la emisora " + state + " del AM desde el fav.";
         }
         else{ // Si es FM
             information += "Seleccionaste la emisora " + state + " del FM desde el fav.";
         }
                         
         return information;
     }
             
     
     /** 
      * @return String
      */
     @Override
     public String toString(){
         return "Radio";
     }
 }