package ru.example.entity;

import java.util.*;

/**
 * Объект, содержащий статистику за период
 * @author ViktoriaGatsulia
 * @version 1.0
 */
public class OutputStat implements OutputMes {
    /**
     * Строка, обозначающая тип возращаемого результата
     */
    private final String type = "stat";
    /**
     * Общее число дней за период из двух дат,
     * включительно, без выходных
     */
    private int totalDays;
    /**
     * Данные по покупателям за этот период,
     * упорядоченные по общей стоимости покупок по убыванию
     */
    private List<UserOutputStat> customers;
    /**
     * Сумма покупок всех покупателей за период
     */
    private double totalExpenses;
    /**
     * Средние затраты всех покупателей за период
     */
    private double avgExpenses;

    /**
     * Базовый конструктор для объекта OutputStat
     */
    public OutputStat() {
    }


    /**
     * Геттер для получения общего числа дней из периода
     *
     * @return общее число дней за период из двух дат, включительно, без выходных
     */
    public int getTotalDays() {
        return totalDays;
    }

    /**
     * Сеттер для установки количества числа дней за период
     * из двух дат, включительно, без выходных
     *
     * @param date1 - дата, которой начинается период
     * @param date2 - дата, которой заканчивается период
     */
    public void setTotalDays(Date date1, Date date2) {
        if (Objects.isNull(date1) || Objects.isNull(date2)) totalDays = 0;
        else totalDays = daysBetween(date1, date2) + 1;
    }

    /**
     * Метод для вычисления количества дней между двумя датами
     * (не включая первый день, т.е. между первым апреля и
     * вторым апреля количество дней будет = 1)
     *
     * @param d1 - первая дата
     * @param d2 - вторая дата
     * @return количество дней между двумя датами
     */
    public int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * Геттер
     * @return Данные по покупателям за этот период,
     * упорядоченные по общей стоимости покупок по убыванию
     */
    public List<UserOutputStat> getCustomers() {
        if (Objects.isNull(customers)) return new ArrayList<>();

        customers.sort(new Comparator<UserOutputStat>() {
            @Override
            public int compare(UserOutputStat o1, UserOutputStat o2) {
                return -(Double.compare(o1.getTotalExpenses(), o2.getTotalExpenses()));
            }
        });

        return customers;
    }

    /**
     * Сеттер
     * @param customers - список покупателей
     */
    public void setCustomers(List<UserOutputStat> customers) {
        this.customers = customers;
    }

    /**
     * Метод для добавления покупателя в период
     * @param userOutputStat - добавляемый покупатель
     */
    public void addCustomers(UserOutputStat userOutputStat) {
        if (Objects.isNull(userOutputStat)) return;
        if (Objects.isNull(customers)) customers = new ArrayList<>();
        customers.add(userOutputStat);
    }

    /**
     * Геттер
     * @return сумма покупок всех покупателей за период
     */
    public double getTotalExpenses() {
        if (Objects.isNull(customers)) return 0.0;
        totalExpenses = 0;
        for (UserOutputStat u : customers) {
            totalExpenses += u.getTotalExpenses();
        }
        return totalExpenses;
    }

    /**
     * Сеттер для установки Общей суммы покупок
     * всех покупателей за период
     */
    public void setTotalExpenses() {
        totalExpenses = this.getTotalExpenses();
    }

    /**
     * Геттер
     * @return Средние затраты всех покупателей за период
     */
    public double getAvgExpenses() {
        if (Objects.isNull(customers)) return 0.0;
        if (customers.size() == 0) return 0;
        avgExpenses = 0;
        for (UserOutputStat u : customers) {
            avgExpenses += u.getTotalExpenses();
        }
        avgExpenses /= customers.size();
        return avgExpenses;
    }

    /**
     * Сеттер для установки средних затрат всех
     * покупателей за период
     */
    public void setAvgExpenses() {
        avgExpenses = this.getAvgExpenses();
    }

    public String getType() {
        return "stat";
    }

}
