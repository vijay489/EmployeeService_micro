package org.example.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Data
public class Flavors {
    String id;
    String type;
    String name;
    String ppu;
    Batters batters;
    List<Toppings> toppingsList;
}
