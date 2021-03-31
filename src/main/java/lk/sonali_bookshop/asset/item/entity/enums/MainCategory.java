package lk.sonali_bookshop.asset.item.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MainCategory {

    COMPUTERS("Computers"),
    COMPUTER_ACCESSORIES("Computer Accessories"),
    FANTECH("Fantech"),
    SSD_HARD_DRIVE("SSD Hard Drive"),
    ELECTRONIC_DEVICES("Electronic Devices"),
    MOBILE_DEVICES("Mobile Devices");


    private final String mainCategory;
}
