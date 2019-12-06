package Day1;

public class LaunchModule{
    private int mass;

    private LaunchModule(){

    }

    public LaunchModule(int mass){
        this.mass = mass;
    }

    public int calculateFuelRequirement(){
        // Integer division provides automatic truncation
        return (this.mass / 3) - 2;
    }
}
