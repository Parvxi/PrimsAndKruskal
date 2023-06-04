
package AlgorithmProjectPart2;

import graphFramework.Vertex;

public class Location extends Vertex {


private String city;

public Location(int Ncity) {
    super(Ncity);
    this.city = String.valueOf((char) (Ncity + 65));
}

@Override
public String displayInfo() {
    return "Router: " + city;
}
}