package site.iblogs.spirng.bucks.demo.model;

import org.hibernate.annotations.Type;
import org.joda.money.Money;

import java.io.Serializable;

public class Coffee extends BaseEntity implements Serializable {
    private String name;
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;
}
