package model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public enum Rank implements AttributeConverter<Rank, Integer> {
    NOBELT(0),
    WHITE(1),
    YELLOW(2),
    GREEN(3),
    PURPLE(4),
    ORANGE(5),
    BLUE(6),
    BROWN(7),
    RED(8),
    BLACK(9);

    public int numericalValue;

    Rank(int numericalValue) {
        this.numericalValue = numericalValue;
    }

    @Override
    public Integer convertToDatabaseColumn(Rank rank) {
        return rank.numericalValue;
    }

    @Override
    public Rank convertToEntityAttribute(Integer integer) {
        return getRankByValue(integer);
    }

    public static Rank getRankByValue(int valueOfRank) {
        for (Rank rank : Rank.values()) {
            if (rank.numericalValue == valueOfRank) {
                return rank;
            }
        }
        throw new IllegalArgumentException("No rank with numerical value: " + valueOfRank);
    }
}