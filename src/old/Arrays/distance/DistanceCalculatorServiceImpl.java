package old.Arrays.distance;

public class DistanceCalculatorServiceImpl {

    public double getDistanceBetweenCoordinates(Coordinate coordinateOne, Coordinate coordinateTwo){
            final double latitudeOne = Math.toRadians(coordinateOne.getLatitude());
        final double longitudeOne = Math.toRadians(coordinateOne.getLongitude());
        final double latitudeTwo = Math.toRadians(coordinateTwo.getLatitude());
        final double longitudeTwo = Math.toRadians(coordinateTwo.getLongitude());

            // Haversine formula
        final double longitudeDifference = longitudeTwo - longitudeOne;
        final double latitudeDifference = latitudeTwo - latitudeOne;
        final double locationDifference = Math.pow(Math.sin(latitudeDifference / 2), 2)
                    + Math.cos(latitudeOne) * Math.cos(latitudeTwo)
                    * Math.pow(Math.sin(longitudeDifference / 2),2);

        final double distance = 2 * Math.asin(Math.sqrt(locationDifference));

        // Radius of earth in kilometers
        final double radiusOfEarthInKM = 6371;

        // calculate the actual distance in Kilometer
        return(distance * radiusOfEarthInKM);
    }
}

class Operation{

    public static void main(String[] args) {
        DistanceCalculatorServiceImpl service = new DistanceCalculatorServiceImpl();
        Coordinate coordinate1 = new Coordinate(56.32055555555556,-1.7297222222222221 );
        Coordinate coordinate2 = new Coordinate(53.31861111111111,  -1.6997222222222223);
        System.out.println(service.getDistanceBetweenCoordinates(coordinate1, coordinate2));
    }
}
