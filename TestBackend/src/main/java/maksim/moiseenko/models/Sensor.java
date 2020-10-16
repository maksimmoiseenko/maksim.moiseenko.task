package maksim.moiseenko.models;

import lombok.*;
import maksim.moiseenko.dto.SensorDto;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String model;
    private String type;
    private String description;
    private String location;
    private int rangeFrom;
    private int rangeTo;
    private String unit;

    public static Sensor from(SensorDto sensorDto){
        return Sensor.builder().description(sensorDto.getDescription())
                .location(sensorDto.getLocation())
                .model(sensorDto.getModel())
                .name(sensorDto.getName())
                .type(sensorDto.getType())
                .unit(sensorDto.getUnit())
                .rangeFrom(sensorDto.getRangeFrom())
                .rangeTo(sensorDto.getRangeTo())
                .build();
    }

    @Override
    public String toString() {
        return name  + model + type + description + location + rangeFrom + rangeTo + unit ;
    }
}
