package ru.example.convert;

import ru.example.entity.Criterias;
import ru.example.entity.entityToJson.*;

import java.util.Objects;

/**
 * Класс для определения типа критерия
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class ConvertCriterias {
    /**
     * Статически метод для конвертации общего критерия в определённый
     * @param c - общий критерий
     * @return - конкретный критерий
     */
    public static CriteriasInterface convertCriterias(Criterias c) {
        boolean last_name_boolean = !Objects.isNull(c.getLast_name());
        boolean product_name_boolean = !Objects.isNull(c.getProduct_name());
        boolean min_times = !Objects.isNull(c.getMin_times());
        boolean min_expenses_boolean = !Objects.isNull(c.getMin_expenses());
        boolean max_expenses_boolean = !Objects.isNull(c.getMax_expenses());
        boolean bad_customers_boolean = !Objects.isNull(c.getBad_customers());
            /*
                Проверка, является ли критерий критерием1
             */
        if (last_name_boolean && !product_name_boolean && !min_times && !min_expenses_boolean && !max_expenses_boolean && !bad_customers_boolean)
        {
            return new Criterias1(c.getLast_name());
        }
            /*
                Проверка, является ли критерий критерием2
             */
        if (!last_name_boolean && product_name_boolean && min_times && !min_expenses_boolean && !max_expenses_boolean && !bad_customers_boolean)
        {
            return new Criterias2(c.getProduct_name(), c.getMin_times());
        }
            /*
                Проверка, является ли критерий критерием3
             */
        if (!last_name_boolean && !product_name_boolean && !min_times && min_expenses_boolean && max_expenses_boolean && !bad_customers_boolean)
        {
            return new Criterias3(c.getMin_expenses(), c.getMax_expenses());
        }
            /*
                Проверка, является ли критерий критерием4
             */
        if (!last_name_boolean && !product_name_boolean && !min_times && !min_expenses_boolean && !max_expenses_boolean && bad_customers_boolean)
        {
            return new Criterias4(c.getBad_customers());
        }
        return null;
    }

}
