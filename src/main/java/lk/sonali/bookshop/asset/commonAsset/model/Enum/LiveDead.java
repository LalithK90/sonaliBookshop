package lk.sonali.bookshop.asset.commonAsset.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LiveDead {
    ACTIVE("Active"),
    STOP("Stop");

    private final String liveDeath;
}
