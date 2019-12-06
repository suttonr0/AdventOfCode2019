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

    public int calculateFuelRequirementConsideringFuelMass(){
        int overallFuelRequirement = 0;
        int stepFuelRequirement = calculateFuelRequirement();
        while (stepFuelRequirement >= 0){
            overallFuelRequirement += stepFuelRequirement;
            stepFuelRequirement = (stepFuelRequirement / 3) - 2;
        }
        return overallFuelRequirement;
    }

}
