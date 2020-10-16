package maksim.moiseenko.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SensorDto {
    private String name;
    private String model;
    private String type;
    private String description;
    private String location;
    private int rangeFrom;
    private int rangeTo;
    private String unit;
}
