/**
 *
 * @author Cristian Laynez
 */

public interface IRatio {
    public String turnOnRatio();
    public String turnOffRatio();
    public String checkFavs();
    public String moveDial(int number);
    public String changeFrecuence();
    public double readCurrentState(int the_dial);
    public double obtainFav(int the_dial);
    public String addFavorite(int the_button_selected, double fav_station);
    public String obtainState(double state);
    public String toString();
}
