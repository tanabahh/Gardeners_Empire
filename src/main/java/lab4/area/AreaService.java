package lab4.area;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

/**
 * сервис для определения местоположения точки
 */
@Service
@Validated
public class AreaService {

    /**
     *
     * @param x координата x область значения от -5 до 5
     * @param y координата y область значения от -3 до 3
     * @param r радиус область значения от 0 до 5
     * @return попадает ли точка в область значений программы
     */
    public boolean contains(
            @DecimalMin(value = "-5") @DecimalMax(value = "5")
                    double x,
            @DecimalMin(value = "-3") @DecimalMax(value = "3")
                    double y,
            @DecimalMin(value = "0") @DecimalMax(value = "5")
                    double r
    ) {
        if (r < 0) {
            return doContains(-x, -y, -r);
        }

        return doContains(x, y, r);
    }

    private boolean doContains(double x, double y, double r) {
        return (
                (x >= 0 && y >= 0 && x <= r && y <= r/2 ) || // rect
                (x <= 0 && y >= 0 && y <= 0.5*( x + r)) || // triangle
                (x <= 0 && y <= 0 && Math.sqrt(x * x + y * y) <= r/2) //arc
        );

    }
}
